package cn.kgc.dao.Impl;

import cn.kgc.dao.DeptDao;
import cn.kgc.domain.Dept;

import java.util.List;

public class DeptDaoImpl implements DeptDao {
    /**
     * mybatis已经将U2阶段所学的DBUtils替代了，所以只需要定义接口
     * 每个接口实现类，mybatis自动映射sql，自动完成
     */
    public List<Dept> selectAll() {
        return null;
    }

    public int insert(Dept dept) {
        return 0;
    }

    public int update(Dept dept) {
        return 0;
    }

    public int delete(int deptNo) {
        return 0;
    }
}
