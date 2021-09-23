package com.mosh.demo2.entity.Menu;

import lombok.*;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * @author mosh
 * @date 2021/9/20 21:45
 */
@Getter
@Setter
public abstract class Menu {

    Integer id;

    String name;

    String path;

    public Menu(Integer id, String name, String path) {
        this.id = id;
        this.name = name;
        this.path = path;
    }

    void addPath(String from) {
        this.path = from + "/" + path;
    }

    public abstract void addChildren(Menu menu) throws OperationNotSupportedException;

    public abstract void deleteChildren(Menu menu) throws OperationNotSupportedException;

    public abstract List<Menu> getChildren();

}
