package org.gd.dijkstra;

import lombok.Value;

import java.util.List;

/**
 * @author Horkhover Dmytro
 * @since 2018-12-17
 */
@Value
class Point {

    int id;

    List<Next> nextPoints;


}
