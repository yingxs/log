package com.yingxs.mybatis.dao;

import com.yingxs.mybatis.bean.Departement;
import com.yingxs.mybatis.bean.DepartementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartementMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dept
     *
     * @mbggenerated Wed Oct 03 19:19:52 CST 2018
     */
    int countByExample(DepartementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dept
     *
     * @mbggenerated Wed Oct 03 19:19:52 CST 2018
     */
    int deleteByExample(DepartementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dept
     *
     * @mbggenerated Wed Oct 03 19:19:52 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dept
     *
     * @mbggenerated Wed Oct 03 19:19:52 CST 2018
     */
    int insert(Departement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dept
     *
     * @mbggenerated Wed Oct 03 19:19:52 CST 2018
     */
    int insertSelective(Departement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dept
     *
     * @mbggenerated Wed Oct 03 19:19:52 CST 2018
     */
    List<Departement> selectByExample(DepartementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dept
     *
     * @mbggenerated Wed Oct 03 19:19:52 CST 2018
     */
    Departement selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dept
     *
     * @mbggenerated Wed Oct 03 19:19:52 CST 2018
     */
    int updateByExampleSelective(@Param("record") Departement record, @Param("example") DepartementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dept
     *
     * @mbggenerated Wed Oct 03 19:19:52 CST 2018
     */
    int updateByExample(@Param("record") Departement record, @Param("example") DepartementExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dept
     *
     * @mbggenerated Wed Oct 03 19:19:52 CST 2018
     */
    int updateByPrimaryKeySelective(Departement record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_dept
     *
     * @mbggenerated Wed Oct 03 19:19:52 CST 2018
     */
    int updateByPrimaryKey(Departement record);
}