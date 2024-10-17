package io.guimgp.backend_wishlist.project.domain.mapper;


import io.guimgp.backend_wishlist.project.domain.dto.debt.CreateDebtRequestDTO;
import io.guimgp.backend_wishlist.project.domain.dto.debt.GetDebtResponseDTO;
import io.guimgp.backend_wishlist.project.domain.dto.debt.UpdateDebtRequestDTO;
import io.guimgp.backend_wishlist.project.domain.dto.wish.UpdateWishRequestDTO;
import io.guimgp.backend_wishlist.project.domain.model.entity.Debt;
import io.guimgp.backend_wishlist.project.domain.model.entity.Wish;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DebtMapper {
    Debt debtRequestToEntity(CreateDebtRequestDTO createDebtRequestDTO);
    GetDebtResponseDTO debtResponseToDto(Debt debt);
    void updateDebtFromDto(UpdateDebtRequestDTO debtDto, @MappingTarget Debt debt);

}
