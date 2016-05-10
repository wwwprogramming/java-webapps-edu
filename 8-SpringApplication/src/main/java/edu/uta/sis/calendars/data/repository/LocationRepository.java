package edu.uta.sis.calendars.data.repository;

import edu.uta.sis.calendars.data.entities.LocationEntity;

/**
 * Created by Hannu Lohtander on 10.5.2016.
 */
public interface LocationRepository {

    public void save(LocationEntity locationEntity);
}
