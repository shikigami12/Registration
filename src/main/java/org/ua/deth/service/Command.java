package org.ua.deth.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by DethGhost on 01.10.2016.
 */
public interface Command {
    String execute(HttpServletRequest req, HttpServletResponse resp4);

}
