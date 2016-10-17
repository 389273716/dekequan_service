package com.dekequan.service.smart.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dekequan.dao.permissions.ModuleDao;
import com.dekequan.dao.permissions.ResourceDao;
import com.dekequan.orm.permissions.Module;
import com.dekequan.orm.permissions.Resource;
import com.dekequan.service.smart.PrivilegeBaseService;

@Service("privilegeBaseServiceImpl")
public class PrivilegeBaseServiceImpl implements PrivilegeBaseService {
	
	@Autowired
	private ModuleDao moduleDaoImpl;
	
	@Autowired
	private ResourceDao resourceDaoImpl;

	public String getModuleTree(Integer userId, String visitedModule, String visitedResource) {

		if (StringUtils.isEmpty(visitedModule)) {
			visitedModule = "";
		}
		if (StringUtils.isEmpty(visitedResource)) {
			visitedResource = "";
		}

		StringBuilder partSb = new StringBuilder();
		// 查询模块
		List<Module> partModuleList = moduleDaoImpl.findModuleList();
		if (CollectionUtils.isEmpty(partModuleList)) {
			System.out.println("ttm | 查询模块为空...");
			return "";
		}

		List<Resource> partResourceList = resourceDaoImpl.findResourceList();
		if (CollectionUtils.isEmpty(partResourceList)) {
			System.out.println("ttm | 查询对应模块功能为空...");
			return "";
		}

		String[] icons = "fa-gift、fa-cogs、fa-puzzle-piece、fa-sitemap、fa-table、fa-briefcase、fa-comments、fa-group、fa-globe、fa-th"
				.split("、");
		int iconsFlag = 0;

		for (Module partModuleRow : partModuleList) {
			if (partModuleRow.getFlag().equals(visitedModule)) {
				partSb.append("<li class='active'>");
			} else {
				partSb.append("<li>");
			}
			partSb.append("<a href=\"javascript:;\">");
			partSb.append("<i class=\"fa " + icons[iconsFlag++] + "\"></i>");
			partSb.append("<span class=\"title\">");
			partSb.append(" " + partModuleRow.getName());
			partSb.append("</span>");
			partSb.append("<span class=\"selected\"></span>");
			partSb.append("<span class=\"arrow open\"></span>");
			partSb.append("</a>");
			partSb.append(buildResourceTree(partModuleRow, partResourceList, "s", visitedModule, visitedResource));
			partSb.append("</li>");
		}
		return partSb.toString();
	}

	private String buildResourceTree(Module m, List<Resource> resourceList, String structure, String visitedModule,
			String visitedResource) {
		if (CollectionUtils.isEmpty(resourceList)) {
			System.out.println("ttm | buildResourceTree -- 传入Resource 集合为空...");
			return "";
		}

		int partParentLength = structure.split("-").length;
		// 计算一级子资源
		List<Resource> partSonList = new ArrayList<Resource>();
		for (Resource partResourceRow : resourceList) {
			if (partResourceRow.getStructure().split("-").length == (partParentLength + 1)
					&& partResourceRow.getStructure().contains(structure)
					&& partResourceRow.getModuleFlag().equals(m.getFlag())) {
				partSonList.add(partResourceRow);
			}
		}

		if (partSonList.size() == 0) {
			return "";
		}

		StringBuilder partSb = new StringBuilder();
		partSb.append("<ul class=\"sub-menu\">");
		for (Resource partResourceRow : partSonList) {
			// 递归，找子级的树形结构
			String s = buildResourceTree(m, resourceList, partResourceRow.getStructure(), visitedModule,
					visitedResource);
			if (visitedResource.contains(partResourceRow.getStructure())
					&& partResourceRow.getModuleFlag().equals(visitedModule)) {
				partSb.append("<li class='active'>");
			} else {
				partSb.append("<li>");
			}
			if (s.equals("")) {
				partSb.append("<a href=\"").append(m.getUrl()).append(partResourceRow.getUrl())
						.append("?visitedModule=").append(partResourceRow.getModuleFlag()).append("&visitedResource=")
						.append(partResourceRow.getStructure()).append("\">");
				partSb.append("<i class=\"fa fa-leaf \"></i>&nbsp;&nbsp;");
				partSb.append(partResourceRow.getName());
				partSb.append("</a>");
			} else {
				partSb.append("<a href=\"javascript:;\">");
				partSb.append("<i class=\"fa fa-folder \"></i>&nbsp;&nbsp;");
				partSb.append(partResourceRow.getName());
				if (visitedResource.contains(partResourceRow.getStructure())
						&& partResourceRow.getModuleFlag().equals(visitedModule)) {
					partSb.append("<span class=\"arrow open\"></span>");
				} else {
					partSb.append("<span class=\"arrow\"></span>");
				}
				partSb.append("</a>");
			}
			partSb.append(s);
			partSb.append("</li>");
		}
		partSb.append("</ul>");
		return partSb.toString();
	}

}
