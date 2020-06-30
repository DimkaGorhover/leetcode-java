package org.gd.hackerrank.cert;

import java.util.*;

/**
 * A number of points along the highway are in need of repair. An equal number of crews are available, stationed at
 * various points along the highway. They must move along the highway to reach an assigned point. Given that one crew
 * must be assigned to each job, what is the minimum total amount of distance traveled by all crews before they can
 * begin work?
 */
class RoarRepair {

    public static long getMinCost(List<Integer> crew_id, List<Integer> job_id) {
        crew_id = new ArrayList<>(crew_id);
        job_id = new ArrayList<>(job_id);

        crew_id.sort(Comparator.naturalOrder());
        job_id.sort(Comparator.naturalOrder());

        long sum = 0;
        int index = -1;
        for (int cId : crew_id) {
            index = Collections.binarySearch(job_id, cId);
            if (index < 0) {
                index = Math.min((-index) - 1, (job_id.size() - 1));
            }
            sum += Math.abs(cId - job_id.get(index));
            job_id.remove(index);
        }

        return sum;
    }
}
