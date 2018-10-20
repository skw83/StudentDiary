package pl.school.common.service;

import java.io.Serializable;
import java.util.Collection;

/**
 * Basic CRUD service interface.
 *
 * @param <D> - Dto
 * @param <I> - Primary Key (ID)
 */

public interface BaseCRUDService<D, I extends Serializable> {

    D save(D dto);

    D update(D dto);

    D find(I id);

    Boolean remove(I id);

    Collection<D> getAll();

}
