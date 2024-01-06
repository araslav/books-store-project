package book.store.mapper;

public interface RequestDtoMapper<D, M> {
    M toModel(D dto);
}
