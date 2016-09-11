<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Main content -->
<section class="content">
	<!-- Your Page Content Here -->
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header" style="background-color: #f5fafe">
					<div class="row">
						<div class="col-xs-2">
							<div class="input-group input-group-sm" style="width: 150px;">
								<div class="input-group-btn">
									<button type="button" class="btn dropdown-toggle">学校名</button>
								</div>
								<!-- /btn-group -->
								<input type="text" class="form-control">
							</div>
						</div>
						<div class="col-xs-2">
							<div class="input-group input-group-sm" style="width: 150px;">
								<div class="input-group-btn">
									<button type="button" class="btn dropdown-toggle">学校代码</button>
								</div>
								<!-- /btn-group -->
								<input type="text" class="form-control">
							</div>
						</div>
						<div class="col-xs-5">
							<div class="input-group input-group-sm" style="width: 450px;">
								<div class="input-group-btn">
									<button type="button" class="btn dropdown-toggle">创建时间</button>
								</div>

								<!-- /btn-group -->
								<input type="text" class="form-control" style="width: 130px;" />
								<input type="text" class="form-control" style="width: 130px;">
							</div>
						</div>
					</div>
				</div>
				<div class="box-header">
					<h3 class="box-title">
						<a href="add-reptile.html"><span class="label label-primary"
							style="padding: 5px 25px;">新增</span></a>
					</h3>
				</div>
				<!-- 头部操作 -->
				<div class="box-body table-responsive">
					<!-- 设置表格不换号显示 -->
					<style>
.table-responsive>.table>tbody>tr>td, .table-responsive>.table>tbody>tr>th,
	.table-responsive>.table>tfoot>tr>td, .table-responsive>.table>tfoot>tr>th,
	.table-responsive>.table>thead>tr>td, .table-responsive>.table>thead>tr>th
	{
	white-space: nowrap;
}
</style>
					<table class="table table-hover table-bordered">
						<tbody>
							<tr style="background-color: #f5fafe">
								<th><input type="checkbox" name="sortAll" /></th>
								<th>ID</th>
								<th>学校名称</th>
								<th>学校代码</th>
								<th>创建人</th>
								<th>创建时间</th>
								<th>操作</th>
							</tr>
							<tr>
								<td><input type="checkbox" name="sort-110" /></td>
								<td>110</td>
								<td>湖南工学院</td>
								<td>10010</td>
								<td>唐太明</td>
								<td>2016-03-24 00:00:00</td>
								<td>
									<a href="#"> <span class="fa fa-fw fa-edit" title="编辑" alt="编辑"></span></a> 
									<a href="#"> <span class="fa fa-fw fa-remove" title="删除" alt="删除"></span></a>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- 内容数据结束 -->
				<div class="box-footer clearfix">
					<div class="row">
						<div class="col-xs-6">
							<div class="dataTables_length">
								<label> 页数 当前第 1 页 - 总共 10 页，每页显示 <select
									class="form-control input-sm" name="example1_length"
									aria-controls="example1">
										<option value="10">10</option>
										<option value="25">25</option>
										<option value="50">50</option>
										<option value="100">100</option>
								</select> 数量
								</label>
							</div>
						</div>
						<div class="col-xs-6">
							<ul class="pagination pagination-sm no-margin pull-right">
								<li class="disabled"><a href="#">«</a></li>
								<li class="active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">»</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>