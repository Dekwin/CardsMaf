package com.dekwin.game.action;

import com.dekwin.game.action.visitor.ActionVisitor;

/**
 * Created by igor on 22.08.17.
 */
public interface Action {
     void accept(ActionVisitor actionVisitor);

}
