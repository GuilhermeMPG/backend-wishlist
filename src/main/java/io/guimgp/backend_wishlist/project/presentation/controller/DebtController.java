package io.guimgp.backend_wishlist.project.presentation.controller;

import io.guimgp.backend_wishlist.project.domain.dto.debt.CreateDebtRequestDTO;
import io.guimgp.backend_wishlist.project.domain.dto.debt.GetDebtResponseDTO;
import io.guimgp.backend_wishlist.project.domain.dto.debt.UpdateDebtRequestDTO;
import io.guimgp.backend_wishlist.project.domain.model.entity.Debt;
import io.guimgp.backend_wishlist.project.presentation.service.DebtService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/debt")
@RequiredArgsConstructor
public class DebtController {
    @Autowired
    private final DebtService debtService;


    // Criar um novo débito
    @PostMapping("/create")
    public ResponseEntity<Void> createDebt(@RequestParam("userId") String userId, @RequestBody @Valid CreateDebtRequestDTO createDebtRequestDTO) {

        return debtService.saveDebt(userId,createDebtRequestDTO);
    }

    // Listar todos os débitos
    @GetMapping("/list")
    public ResponseEntity<List<GetDebtResponseDTO>> getAllDebts(@RequestParam("userId") String userId) {

        return ResponseEntity.ok(debtService.getAllDebts(userId));
    }

    // Buscar um débito por ID
    @GetMapping("/{debtId}")
    public ResponseEntity<GetDebtResponseDTO> getDebtById(@RequestParam("userId") String userId, @PathVariable Long debtId) {
        return  ResponseEntity.ok(debtService.getDebtById(debtId));
    }

    // Atualizar um débito por ID
    @PutMapping("/{debtId}")
    public ResponseEntity<Void> updateDebt(@RequestParam("userId") String userId, @PathVariable Long debtId, @RequestBody @Valid UpdateDebtRequestDTO updatedDebt) {
        return  debtService.updateDebt(debtId, updatedDebt);
    }

    // Deletar um débito por ID
    @DeleteMapping("/{debtId}")
    public ResponseEntity<String> deleteDebt(@RequestParam("userId") String userId, @PathVariable Long debtId) {
        return debtService.deleteDebt(debtId, userId);
    }


}
