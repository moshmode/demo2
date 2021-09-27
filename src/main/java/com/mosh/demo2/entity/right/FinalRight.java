package com.mosh.demo2.entity.right;

import lombok.*;

import javax.naming.OperationNotSupportedException;
import java.util.List;

/**
 * Description
 *
 * @author mosh
 * @date 2021/9/21 10:05
 */

public class FinalRight extends Right {

    public FinalRight(Integer id, String name, String path) {
        super(id, name, path);
    }

    @Override
    public void addChildren(Right right) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    @Override
    public void deleteChildren(Right right) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    @Override
    public List<Right> getChildren() {
        return null;
    }


}
