package org.gd.dijkstra;

import lombok.Value;

import java.util.List;

/**
 * @author Horkhover Dmytro
 * @since 2018-12-17
 */
@Value
class Point {

    int        id;
    boolean    finish;
    List<Next> nextPoints;

    static Point finish(int id) {
        return new Point(id, true, List.of());
    }
}
