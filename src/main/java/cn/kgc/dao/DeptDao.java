package cn.kgc.dao;

import cn.kgc.domain.Dept;

import java.util.List;

public interface DeptDao {
    /**
     * 查询徐所有的部门信息
     * @return返回部门信息集合
     */
    List<Dept> selectAll();
//    添加
    int insert(Dept dept);
//    修改
    int update(Dept dept);
//    删除
    int delete(int deptNo);
}
