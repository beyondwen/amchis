package com.amchis.mapper;

import com.amchis.bean.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {
    List<Menu> getAllMenu();

    List<Menu> getMenusByuId(Long uId);

    List<Menu> menuTree();

    List<Long> getMenusByRid(Long rid);
}
