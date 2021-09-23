package com.mosh.demo2.entity.Menu;

import lombok.*;

import javax.naming.OperationNotSupportedException;
import java.util.List;

/**
 * Description
 *
 * @author mosh
 * @date 2021/9/21 10:05
 */

@ToString
public class FinalMenu extends Menu {

    public FinalMenu(Integer id, String name, String path) {
        super(id, name, path);
    }

    @Override
    public void addChildren(Menu menu) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    @Override
    public void deleteChildren(Menu menu) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    @Override
    public List<Menu> getChildren() {
        return null;
    }


}
