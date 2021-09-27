package com.mosh.demo2.entity.right;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * @author mosh
 * @date 2021/9/21 10:04
 */
public class MulRight extends Right {

    List<Right> children = new ArrayList<>();

    public MulRight(Integer id, String name, String path) {
        super(id, name, path);
    }

    @Override
    public void addChildren(Right right) {
//        menu.addPath(this.getPath());
        children.add(right);
    }

    @Override
    public void deleteChildren(Right right) {
        children.remove(right);
    }

    @Override
    public List<Right> getChildren() {
        return this.children;
    }

    @Override
    public void addPath(String from) {
        this.path = from + "/" + path;
        for (Right child : this.getChildren()) {
            child.addPath(from);
        }
    }


}
