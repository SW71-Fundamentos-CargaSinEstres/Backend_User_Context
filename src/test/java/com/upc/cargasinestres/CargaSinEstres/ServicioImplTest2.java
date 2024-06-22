package com.upc.cargasinestres.CargaSinEstres;

import com.upc.cargasinestres.CargaSinEstres.Shared.exception.ValidationException;
import com.upc.cargasinestres.CargaSinEstres.UsersContext.model.dto.Company.request.CompanyRequestDto;
import com.upc.cargasinestres.CargaSinEstres.UsersContext.model.entity.Company;
import com.upc.cargasinestres.CargaSinEstres.UsersContext.repository.ICompanyRepository;
import com.upc.cargasinestres.CargaSinEstres.UsersContext.service.impl.CompanyServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class CompanyImplTest {

	@Mock
	private ICompanyRepository companyRepository;

	@InjectMocks
	private CompanyServiceImpl companyService;

	public CompanyImplTest() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createServiceWhenServiceNameExists() {
		String existingServiceName = "existingService";
		CompanyRequestDto requestDto = new CompanyRequestDto();
		requestDto.setName(existingServiceName);
		Company existingCompany = new Company();
		existingCompany.setName(existingServiceName);

		when(companyRepository.findByName(existingServiceName)).thenReturn(Optional.of(existingCompany));

		assertThrows(ValidationException.class, () -> companyService.createCompany(requestDto));
	}
}