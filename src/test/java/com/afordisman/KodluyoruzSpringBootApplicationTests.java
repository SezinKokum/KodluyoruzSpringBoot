package com.afordisman;

import com.afordisman.data.entity.EmployeeEntity;
import com.afordisman.data.repository.EmployeeRepository;
import com.afordisman.test.TestCrud;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class KodluyoruzSpringBootApplicationTests implements TestCrud {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    @Override
    public void testCreate() {
        EmployeeEntity employeeEntity = EmployeeEntity
                .builder()
                .firstName("Sezin test")
                .lastName("Kokum Mutludogan Test")
                .emailId("sezinkokum@gmail.com")
                .build();
        employeeRepository.save(employeeEntity);
        //Nesne null ise assertionError hatasını göndersin
        assertNotNull(employeeRepository.findById(1L));
    }

    @Test
    @Override
    public void testList() {
        List<EmployeeEntity> list = employeeRepository.findAll();
        //Eğer 0 dan büyükse liste vardır
        assertThat(list).size().isGreaterThan(0);
    }

    @Test
    @Override
    public void testFindById() {
        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();
        //Sezin test adında kayıt var mı yok mu
        assertEquals("Sezin test",employeeEntity.getFirstName());
    }

    @Test
    @Override
    public void testUpdate() {
        EmployeeEntity employeeEntity = employeeRepository.findById(1L).get();
        employeeEntity.setFirstName("Sezin 16 test");
        employeeRepository.save(employeeEntity);
        //Eşit değilse bir sorun olmayacak ama eşitse exception fırlatsın
        assertNotEquals("Sezin test",employeeRepository.findById(1L).get().getFirstName());
    }

    @Test
    @Override
    public void testDelete() {
        employeeRepository.deleteById(1L);
        //isFalse
        assertThat(employeeRepository.existsById(1L)).isFalse();
    }
}
