package com.mosh.demo2.entity.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * @author mosh
 * @date 2021/9/21 10:04
 */
public class MulMenu extends Menu {

    List<Menu> children = new ArrayList<>();

    public MulMenu(Integer id, String name, String path) {
        super(id, name, path);
    }

    @Override
    public void addChildren(Menu menu) {
//        menu.addPath(this.getPath());
        children.add(menu);
    }

    @Override
    public void deleteChildren(Menu menu) {
        children.remove(menu);
    }

    @Override
    public List<Menu> getChildren() {
        return this.children;
    }

    @Override
    public void addPath(String from) {
        this.path = from + "/" + path;
        for (Menu child : this.getChildren()) {
            child.addPath(from);
        }
    }


}
