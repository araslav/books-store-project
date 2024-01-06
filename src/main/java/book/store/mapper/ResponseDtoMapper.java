package book.store.mapper;

public interface ResponseDtoMapper<M, D> {
    D toDto(M model);
}
