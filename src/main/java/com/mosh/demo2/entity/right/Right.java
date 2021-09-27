package com.mosh.demo2.entity.right;

import lombok.*;

import javax.naming.OperationNotSupportedException;
import java.util.List;

/**
 * Description
 *
 * @author mosh
 * @date 2021/9/20 21:45
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public abstract class Right {

    Integer id;

    String name;

    String path;

    public Right(Integer id, String name, String path) {
        this.id = id;
        this.name = name;
        this.path = path;
    }

    void addPath(String from) {
        this.path = from + "/" + path;
    }

    public abstract void addChildren(Right right) throws OperationNotSupportedException;

    public abstract void deleteChildren(Right right) throws OperationNotSupportedException;

    public abstract List<Right> getChildren();

}
