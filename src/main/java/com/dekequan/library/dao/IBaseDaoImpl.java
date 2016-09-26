package com.dekequan.library.dao;

import com.dekequan.library.core.Po;
import com.dekequan.library.core.Pram;
import com.dekequan.library.core.WherePrams;
import com.dekequan.library.core.annotation.po.FieldName;
import com.dekequan.library.core.sql.utils.GenericsUtils;
import com.dekequan.library.core.sql.utils.SqlUtil;
import com.dekequan.library.utils.Json;
import com.dekequan.library.utils.Print;
import com.dekequan.library.utils.QueryHelper;
import com.google.gson.Gson;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 基本数据库操作实现类
 * @Author 佘俊
 * @Date 2016/9/18 22:07
 * @email shejun1123@163.com
 */
@ContextConfiguration(locations = {"classpath:/com/dekequan/spring/applicationContext.xml", "classpath:/com/dekequan/spring/dispatcher-servlet.xml"})
@Repository
public class IBaseDaoImpl<T extends Po, PK extends Serializable> implements IBaseDao<T, PK> {

    private SqlSessionTemplate sqlSessionTemplate;

    private Class<T> entityClass;

    private String pkName;                  //主键字段

    private String idName;                  //对应id名称

    private String seq;                     //当前主键

    private String tableName;

    private List<Pram> sqlParms;


    private List<Pram> selectSqlParms;

    private SqlUtil<T> sqlUtil;

    @SuppressWarnings("unchecked")
    public IBaseDaoImpl(){
        super();
        ApplicationContext context = new ClassPathXmlApplicationContext("com/dekequan/spring/applicationContext.xml");
       sqlSessionTemplate = (SqlSessionTemplate) context.getBean("sqlSessionTemplate");
        this.sqlUtil = new SqlUtil<T>();

        this.entityClass = (Class<T>) GenericsUtils.getSuperClassGenricType(this.getClass());

        this.sqlParms = this.sqlUtil.getPramList(this.entityClass);

        this.selectSqlParms = this.sqlUtil.getPramListOfSelect(this.entityClass);

        this.tableName = "dk_"+this.sqlUtil.getTableName(this.entityClass);

        //习惯统一用‘id’做约束了，所以这里我给固定死了，不想固定的话可以修改这里
        this.pkName = "id";

        this.idName = this.sqlUtil.getTableName(this.entityClass)+"_id";

        this.seq = "id";
        Print.print(idName);
    }


    @Override
    public int addLocal(T po) {
        // TODO Auto-generated method stub

        String sql = "insert into " + tableName + " (";
        String prams = "";
        String values = "";

        List<Pram> pramList = SqlUtil.getPramListofStatic(po);

        int index = 0;
        for (int i = 0; i < pramList.size(); i++) {
            if (pramList.get(i).getValue() == null || (pramList.get(i).getValue() + "") .equals("0")) {
                continue;
            }else{
                if(index > 0){
                    prams += ",";
                    values += ",";
                }
                prams += pramList.get(i).getFile();
                Object value = pramList.get(i).getValue();
                if (value instanceof byte[] ) {
                    values += "'" + new String((byte[]) value) + "'";
                }else if(value instanceof String){
                    values += "'" + value + "'";
                }else{
                    values += value ;
                }

                index ++;
            }
        }
        sql += prams + ") value (" + values +");";

        SqlUtil.setFileValue(po, "id", nextId());

        System.out.println(sql);
        return sqlSessionTemplate.insert("addLocal", sql);

    }

    @Override
    public int add(T po) {
        // TODO Auto-generated method stub
        String sql = "insert into " + tableName + " (";
        String prams = "";
        String values = "";

        List<Pram> pramList = SqlUtil.getPramListofStatic(po);

        for (int i = 0; i < pramList.size(); i++) {
            prams += pramList.get(i).getFile();
            if (pramList.get(i).getValue() == null) {
                values += "null";
            }else{
                values += "'" + pramList.get(i).getValue() + "'";
            }

            if(i < pramList.size() -1){
                prams += ",";
                values += ",";
            }
        }
        sql += prams + ") value (" + values +");";

        SqlUtil.setFileValue(po, "id", nextId());

        return sqlSessionTemplate.insert("add", sql);
    }

    @Override
    public T get(PK id) {
        // TODO Auto-generated method stub
        String sql = "select ";
        for (int i = 0; i < selectSqlParms.size(); i++) {
            sql += selectSqlParms.get(i).getFile();
            if(i < selectSqlParms.size() -1){
                sql += ",";
            }else{
                sql += " ";
            }
        }
        sql += " from " + tableName + " where "+ idName +" = "+ id + ";";
        Map<String, Object> resultMap = sqlSessionTemplate.selectOne(
                "getById", sql);

        return handleResult(resultMap, this.entityClass);
    }

    @Override
    public Serializable getField(PK id, String fileName) {
        // TODO Auto-generated method stub
        String field = fileName;
        String tabField = "";
        Field f = sqlUtil.getField(this.entityClass, fileName);
        if (null == f) {
            System.out.println("查询字段失败(无法找到" + this.entityClass + "中的" + fileName + "字段)");
        }
        FieldName annotation = f.getAnnotation(FieldName.class);
        if (null == annotation) {
            tabField = sqlUtil.toTableString(fileName) + " as " + fileName;
        }else{
            tabField = annotation.name() + " as " + fileName;
        }

        String sql = "select ";
        sql += tabField + " from " + tableName + " where id='" + id + "';";
        Map<String, Object> resultMap = sqlSessionTemplate.selectOne(
                "getFieldById", sql);
        return (Serializable) resultMap.get(fileName);
    }

    @Override
    public T get(WherePrams where) {
        // TODO Auto-generated method stub
        String sql = "select ";
        for (int i = 0; i < selectSqlParms.size(); i++) {
            sql += selectSqlParms.get(i).getFile();
            if(i < selectSqlParms.size() -1){
                sql += ",";
            }else{
                sql += " ";
            }
        }
        sql += "from " + tableName + where.getWherePrams() + ";";
        Print.print(sqlSessionTemplate);
        Map<String, Object> resultMap = sqlSessionTemplate.selectOne(
                "getByParm", sql);

        return handleResult(resultMap, this.entityClass);
    }

    @Override
    public Serializable getFile(WherePrams where, String fileName) {
        // TODO Auto-generated method stub
        String field = fileName;
        String tabField = "";
        Field f = sqlUtil.getField(this.entityClass, fileName);
        if (null == f) {
            System.out.println("查询字段失败(无法找到" + this.entityClass + "中的" + fileName + "字段)");
        }
        FieldName annotation = f.getAnnotation(FieldName.class);
        if (null == annotation) {
            tabField = sqlUtil.toTableString(fileName) + " as " + fileName;
        }else{
            tabField = annotation.name() + " as " + fileName;
        }

        String sql = "select ";
        sql += tabField + " from " + tableName + where.getWherePrams() + ";";
        Map<String, Object> resultMap = sqlSessionTemplate.selectOne(
                "getFieldByParm", sql);
        return (Serializable) resultMap.get(fileName);
    }

    @Override
    public List<T> list(WherePrams where) {
        // TODO Auto-generated method stub

        String sql = "select ";
        for (int i = 0; i < selectSqlParms.size(); i++) {
            sql += selectSqlParms.get(i).getFile();
            if(i < selectSqlParms.size() -1){
                sql += ",";
            }else{
                sql += " ";
            }
        }
        sql += "from " + tableName + where.getWherePrams() + ";";

        List<Map<String, Object>> selectList = sqlSessionTemplate.selectList("selectList", sql);

        List<T> list = new ArrayList<T>();
        for (Map<String, Object> map : selectList) {
            T t = handleResult(map, this.entityClass);
            list.add(t);
        }

        return list;

    }

    @Override
    public Serializable[] listFile(WherePrams where, String fileName) {
        // TODO Auto-generated method stub

        String field = fileName;
        String tabField = "";
        Field f = sqlUtil.getField(this.entityClass, fileName);
        if (null == f) {
            System.out.println("查询指定字段集失败(无法序列化" + this.entityClass + "中的" + fileName + "字段)");
        }
        FieldName annotation = f.getAnnotation(FieldName.class);
        if (null == annotation) {
            tabField = sqlUtil.toTableString(fileName) + " as " + fileName;
        }else{
            tabField = annotation.name() + " as " + fileName;
        }

        String sql = "select ";
        sql += tabField + " from " + tableName + where.getWherePrams() + ";";
        List<Map<String, Object>> resultMap = sqlSessionTemplate.selectList("selectListField", sql);

        Serializable[] fields = new Serializable[resultMap.size()];

        for (int i = 0; i < resultMap.size(); i++) {
            if (null != resultMap.get(i)) {
                fields[i] =(Serializable) resultMap.get(i).get(fileName);
            }
        }

        return fields;
    }

    @Override
    public List<Map<String, Serializable>> listFiles(WherePrams where, String[] files) {
        // TODO Auto-generated method stub
        String tabField = "";
        int index = 1;
        for (String field : files) {
            Field f = sqlUtil.getField(this.entityClass, field);
            if (null == f) {
                System.out.println("查询指定字段集失败(无法序列化" + this.entityClass + "中的" + field + "字段)");
            }
            FieldName annotation = f.getAnnotation(FieldName.class);
            if (null == annotation) {
                tabField += sqlUtil.toTableString(field) + " as " + field;
            }else{
                tabField += annotation.name() + " as " + field;
            }
            if (index < files.length) {
                tabField += ",";
            }

            index ++;
        }

        String sql = "select ";
        sql += tabField + " from " + tableName + where.getWherePrams() + ";";
        List<Map<String, Serializable>> resultMap = sqlSessionTemplate.selectList("selectListField", sql);

        return resultMap;
    }

    @Override
    public int updateLocal(T po) {
        // TODO Auto-generated method stub

        Serializable id = sqlUtil.getFileValue(po, "id");

        if(null == id){
            return 0;
        }
        String sql = "update " + tableName + " set ";
        List<Pram> prams = sqlUtil.getPramList(po);
        for (int i = 0; i < prams.size(); i++) {
            if(null != prams.get(i).getValue()){
                sql += prams.get(i).getFile() + "=";
                Object value = prams.get(i).getValue();
                if (value instanceof byte[] ) {
                    sql += "'" + new String((byte[]) value) + "'";
                }else if(value instanceof String){
                    sql += "'" + value + "'";
                }else{
                    sql += value ;
                }

//              sql += prams.get(i).getFile() + "='" + prams.get(i).getValue() + "'";
                if (i < prams.size() -1) {
                    sql += ",";
                }
            }
        }
        sql += " where id='" + id +"';";

        return sqlSessionTemplate.update("updateLocal", sql);
    }

    @Override
    public int update(T po) {
        // TODO Auto-generated method stub

        Serializable id = sqlUtil.getFileValue(po, "id");

        if(null == id){
            return 0;
        }
        String sql = "update " + tableName + " set ";

        List<Pram> prams = sqlUtil.getPramList(po);

        for (int i = 0; i < prams.size(); i++) {
            if(null != prams.get(i).getValue()){
                sql += prams.get(i).getFile() + "=";
                Object value = prams.get(i).getValue();
                if (value instanceof byte[] ) {
                    sql += "'" + new String((byte[]) value) + "'";
                }else if(value instanceof String){
                    sql += "'" + value + "'";
                }else{
                    sql += value ;
                }
//              sql += prams.get(i).getFile() + "='" + prams.get(i).getValue() + "'";
                if (i < prams.size() -1) {
                    sql += ",";
                }
            }else{
                sql += prams.get(i).getFile() + "=null";
                if (i < prams.size() -1) {
                    sql += ",";
                }
            }
        }
        sql += " where id='" + id +"';";

        return sqlSessionTemplate.update("update", sql);
    }

    @Override
    public int updateLocal(T po, WherePrams where) {
        // TODO Auto-generated method stub

        String sql = "update " + tableName + " set ";
        List<Pram> prams = sqlUtil.getPramList(po);
        for (int i = 0; i < prams.size(); i++) {
            if(null != prams.get(i).getValue()){
                sql += prams.get(i).getFile() + "=";
                Object value = prams.get(i).getValue();
                if (value instanceof byte[] ) {
                    sql += "'" + new String((byte[]) value) + "'";
                }else if(value instanceof String){
                    sql += "'" + value + "'";
                }else{
                    sql += value ;
                }
//              sql += prams.get(i).getFile() + "='" + prams.get(i).getValue() + "'";
                if (i < prams.size() -1) {
                    sql += ",";
                }
            }
        }
        sql += where.getWherePrams() +"';";

        return sqlSessionTemplate.update("updateLocalByPram", sql);

    }

    @Override
    public int update(T po, WherePrams where) {
        // TODO Auto-generated method stub

        String sql = "update " + tableName + " set ";
        Object[] o = new Object[sqlParms.size()];
        for (int i = 0; i < sqlParms.size(); i++) {
            if(null != sqlParms.get(i).getValue()){
                sql += sqlParms.get(i).getFile() + "=" + sqlParms.get(i).getValue();
                if (i < sqlParms.size() -1) {
                    sql += ",";
                }
            }else{
                sql += sqlParms.get(i).getFile() + "=null";
                if (i < sqlParms.size() -1) {
                    sql += ",";
                }
            }
        }
        sql += where.getWherePrams() + "';";

        return sqlSessionTemplate.update("updateByPram", sql);

    }

    @Override
    public int del(PK id) {
        // TODO Auto-generated method stub
        String sql = "delete from " + tableName + " where id=" + id;

        return sqlSessionTemplate.delete("deleteById", sql);
    }

    @Override
    public int del(WherePrams where) {
        // TODO Auto-generated method stub

        String sql = "delete from " + tableName + where.getWherePrams();

        return sqlSessionTemplate.delete("deleteByparm", sql);
    }

    @Override
    public List<Map<String, Object>> listBySql(String sql) {
        // TODO Auto-generated method stub

        List<Map<String, Object>> selectList = sqlSessionTemplate.selectList("selectBySql", sql);
        return selectList;
    }

    @Override
    public int excuse(String sql) {
        // TODO Auto-generated method stub
        return sqlSessionTemplate.update("excuse", sql);
    }

    @Override
    public long count(WherePrams where) {
        // TODO Auto-generated method stub

        String sql = "select count(*) from ";

        sql += tableName + where.getWherePrams();

        long count = sqlSessionTemplate.selectOne("selectCountByParm", sql);

        return count;
    }

    @Override
    public long size() {
        // TODO Auto-generated method stub
        String sql = "select count(*) from " + tableName;
        long count = sqlSessionTemplate.selectOne("selectCount", sql);
        return count;
    }

    @Override
    public boolean isExist(T po) {
        // TODO Auto-generated method stub
        WherePrams wherePrams = QueryHelper.createDefault();

        List<Pram> list = SqlUtil.getPramListofStatic(po);

        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                wherePrams = QueryHelper.where(list.get(i).getFile(), QueryHelper.EQ, (Serializable)list.get(i).getValue());
            }else{
                wherePrams.and(list.get(i).getFile(), QueryHelper.EQ, (Serializable)list.get(i).getValue());
            }
        }


        return count(wherePrams) > 0;
    }

    @Override
    public boolean isExist(WherePrams where) {
        // TODO Auto-generated method stub
        return count(where) > 0;
    }

    @Override
    public List<T> in(String fileName, Serializable[] values) {
        // TODO Auto-generated method stub

        String sql = "select ";
        for (int i = 0; i < sqlParms.size(); i++) {
            sql += selectSqlParms.get(i).getFile();
            if(i < selectSqlParms.size() -1){
                sql += ",";
            }else{
                sql += " ";
            }
        }
        sql += "from " + tableName + " where " + fileName + " in ";
        String value = "(";
        for(int i = 0; i < values.length; i++){
            if(i < values.length -1){
                value += values[i] + ",";
            }else{
                value += values[i] + ");";
            }
        }
        sql += value;

        List<Map<String, Object>> selectList = sqlSessionTemplate.selectList("selectIn", sql);

        List<T> list = new ArrayList<T>();
        for (Map<String, Object> map : selectList) {
            T t = handleResult(map, this.entityClass);
            list.add(t);
        }

        return list;
    }

    private T handleResult(Map<String, Object> resultMap, Class<T> tClazz) {
        if (null == resultMap) {
            return null;
        }
        T t = null;
        try {
            t = tClazz.newInstance();
            Gson gson = new Gson();
            String json = gson.toJson(resultMap);
            t = (T) Json.fromJson(json, tClazz);
        } catch (InstantiationException e) {
            System.out.println("/********************************");
            System.out.println("实例化Bean失败(" + this.entityClass + ")!"
                    + e.getMessage());
            System.out.println("/********************************");
        } catch (IllegalAccessException e) {
            System.out.println("/********************************");
            System.out.println("实例化Bean失败(" + this.entityClass + ")!"
                    + e.getMessage());
            System.out.println("/********************************");
        }

//        for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
//            String key = entry.getKey();
//            Serializable val = (Serializable) entry.getValue();
//            try {
//                SqlUtil.setFileValue(t, key, val);
//            } catch (Exception e) {
//                // TODO: handle exception
//                System.out.println("/********************************");
//                System.out.println("/实例化Bean失败(" + this.entityClass + ")不能赋值到字段(" + key + "):"
//                        + e.getMessage());
//                System.out.println("/********************************");
//            }
//        }
        return t;
    }

    /**
     * 获取某表的下一个Id
     */
    public long nextId(){
        String sql = "SELECT auto_increment FROM information_schema.`TABLES` WHERE TABLE_NAME='" + tableName + "'";
        Long idVal = sqlSessionTemplate.selectOne("fetchSeqNextval", sql);
        if (null == idVal) {
            System.out.println("/********************************");
            System.out.println("/获取id失败，" + tableName + "表异常。请检查是否存在或者配为自增主键");
            System.out.println("/********************************");
            return 0;
        }
        return idVal;

    }

}
