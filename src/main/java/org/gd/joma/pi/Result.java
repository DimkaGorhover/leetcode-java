package org.gd.joma.pi;

/**
 * @author Horkhover Dmytro
 * @since 2020-08-18
 */
record Result(long inCircle, long total) {

    static Result ZERO = new Result(0, 0);

    Result merge(Result o) {
        return new Result((inCircle + o.inCircle), (total + o.total));
    }

    double pi() { return 4d * inCircle / total; }
}
