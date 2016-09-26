package com.dekequan.library.core;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询条件类
 * @Author 佘俊
 * @Date 2016/9/18 22:19
 * @email shejun1123@163.com
 */
public class WherePrams {

    private String pram;

    private String limit;

    private String orderBy;

    private List<Serializable> parms = new ArrayList<Serializable>();

    private List<Serializable> limitParms = new ArrayList<Serializable>();

    //	private WherePrams(String prams){
//		pram = " where " + prams;
//	}
//
    public WherePrams(String file, String where, Serializable value){

        if(null == file && null == where && value == where){
            return;
        }

        if (null == value) {

            if (where.equals("=")) {
                where = " is";
            }else{
                where = " not ";
            }
            this.pram = " where " + file + where + "null";
        }else{
            if ("like".equals(where)) {
                this.pram = " where " + file + where + " '%" + value + "%'";
            }else{
                this.pram = " where " + file + where + " '" + value + "'";
            }
        }








//		this.pram = " where " + file + where + "?";
//		if("like".equals(where)){
//			parms.add("%" + value + "%");
//		}else{
//			parms.add(value);
//		}
    }

    /**
     * and条件
     * @param file
     * @param where
     * @param value
     * @return
     */
    public WherePrams and(String file, String where, Serializable value){
        if (null == value) {
            if (where.equals("=")) {
                where = " is";
            } else {
                where = " not ";
            }
            this.pram = " and " + file + where + "null";
        } else {
            if ("like".equals(where)) {
                this.pram += " and " + file + " " + where + " '%" + value + "%'";
            }else{
                this.pram += " and " + file + " " + where + " '" + value + "'";
            }
        }



//		if("like".equals(where)){
//			this.pram = " where " + file + where + "%" + value + "%";
////			this.pram += " and " + file + " " + where + " ?";
////			parms.add("%" + value + "%");
//		}else{
//			this.pram = " where " + file + where + value;
////			this.pram += " and " + file + " " + where + " ?";
////			parms.add(value);
//		}

        return this;
    }

/*	*//**
     * or条件
     * @param pram
     * @return
     *//*
	public WherePrams or(String pram){
		this.pram += " or " + pram;
		return this;
	}*/

    /**
     * or条件
     * @param file
     * @param where
     * @param value
     * @return
     */
    public WherePrams or(String file, String where, Serializable value){
        if (null == value) {
            if (where.equals("=")) {
                where = " is";
            } else {
                where = " not ";
            }
            this.pram = " or " + file + where + "null";
        } else {
            if ("like".equals(where)) {
                this.pram += " or " + file + where + " '%" + value + "%'";
            }else{
                this.pram += " or " + file + where + " '" + value + "'";
            }
        }



//		if("like".equals(where)){
////			this.pram += " or " + file + " " + where + " ?";
//			this.pram = " or " + file + where + "%" + value + "%";
////			parms.add("%" + value + "%");
//		}else{
//			this.pram = " or " + file + where + value;
////			this.pram += " or " + file + " " +  where + " ?";
////			parms.add(value);
//		}
        return this;
    }

    public WherePrams limit(int startNum, int length) {
        // TODO Auto-generated constructor stub
//		this.limit = " limit ? , ? ";
        this.limit = " limit " + startNum + " , " + length + " ";
//		limitParms.add(startNum);
//		limitParms.add(length);
        return this;
    }

    public WherePrams orderBy(String order){
        if(this.orderBy != null){
            this.orderBy += "," + order;
        }else{
            this.orderBy = order;
        }
        return this;
    }

    @Override
    public String toString() {
        return "WherePrams [pram=" + pram + "]";
    }

    /**
     * 获取prams
     * @return
     */
    public String getWherePrams(){
        String p = "";
        p += null == this.pram ? "" : this.pram;
        p += null == this.orderBy ? "" : (" order by " + this.orderBy);
        p += null == this.limit ? "" : this.limit;
        return p;
    }

    public Serializable[] listParmsByFmt(){
        parms.addAll(limitParms);
        return parms.toArray(new Serializable[parms.size()]);
    }

    public Serializable[] listParms(){
        int length = getWherePrams().indexOf("?");
        if(-1 == length){
            return new Serializable[0];
        }
//		if(null != orderBy){
//			parms.add(orderBy);
//		}
        parms.addAll(limitParms);
        return parms.toArray(new Serializable[parms.size()]);
    }
}

