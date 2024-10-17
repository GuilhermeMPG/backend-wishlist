package io.guimgp.backend_wishlist.project.presentation.service;

import io.guimgp.backend_wishlist.project.domain.dto.debt.CreateDebtRequestDTO;
import io.guimgp.backend_wishlist.project.domain.dto.debt.GetDebtResponseDTO;
import io.guimgp.backend_wishlist.project.domain.dto.debt.UpdateDebtRequestDTO;
import io.guimgp.backend_wishlist.project.domain.dto.wish.UpdateWishRequestDTO;
import io.guimgp.backend_wishlist.project.domain.mapper.DebtMapper;
import io.guimgp.backend_wishlist.project.domain.model.entity.User;
import io.guimgp.backend_wishlist.project.domain.model.entity.Wish;
import io.guimgp.backend_wishlist.project.domain.model.repository.DebtRepository;
import io.guimgp.backend_wishlist.project.domain.model.repository.UserRepository;
import io.guimgp.backend_wishlist.project.infrastructure.exceptions.EntityNotFoundCustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import io.guimgp.backend_wishlist.project.domain.model.entity.Debt;

import java.util.List;
import java.util.UUID;

@Service
public class DebtService {
    @Autowired
    private DebtRepository debtRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DebtMapper debtMapper;




    public ResponseEntity<Void> saveDebt(String userId, CreateDebtRequestDTO createDebtRequestDTO) {
        User user = this.userRepository.findById(UUID.fromString(userId)).orElseThrow(() -> new EntityNotFoundCustomException(userId));

        Debt newDebt = debtMapper.debtRequestToEntity(createDebtRequestDTO);

        newDebt.setUser(user);

        debtRepository.save(newDebt);

        return ResponseEntity.ok().build();
    }

    public  List<GetDebtResponseDTO> getAllDebts(String userId) {
        User user = this.userRepository.findById(UUID.fromString(userId)).orElseThrow(() -> new EntityNotFoundCustomException(userId));

        return user.getDebts().stream().map(debt->
                debtMapper.debtResponseToDto(debt)
        ).toList();

    }

    public GetDebtResponseDTO getDebtById(Long debtId) {
        Debt recoveredDebt = debtRepository.findById(debtId)
                .orElseThrow(() -> new EntityNotFoundCustomException(debtId));


        return debtMapper.debtResponseToDto(recoveredDebt);

    }

    public ResponseEntity<Void> updateDebt(Long debtId, UpdateDebtRequestDTO bodyDebtDTO) {
        Debt recoveredDebt = debtRepository.findById(debtId)
                .orElseThrow(() -> new EntityNotFoundCustomException(debtId));



        debtMapper.updateDebtFromDto(bodyDebtDTO, recoveredDebt);
        debtRepository.save(recoveredDebt);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    public ResponseEntity<String> deleteDebt(Long debtId, String userId) {
        Debt recoveredDebt = debtRepository.findById(debtId)
                .orElseThrow(() -> new EntityNotFoundCustomException(debtId));
        if (recoveredDebt.getUser().getUser_id().equals(UUID.fromString(userId))) {
            debtRepository.deleteById(debtId);
            return new ResponseEntity<>("Debt deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);

    }
}
