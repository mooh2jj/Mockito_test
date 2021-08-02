package com.example.mocktest;

import com.example.mocktest.model.Animal;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class ExampleUnitTest {

    @Mock
    Animal animal;

    @Test
    public void mockTest() {
//        MockitoAnnotations.initMocks(this);
        // 아래 코드로도 Mock 객체 생성 가능
        Animal animal = mock(Animal.class);
//        assertTrue(animal != null);
//
//        when(animal.getAge()).thenReturn(30);
//        when(animal.getName()).thenReturn("참새");
//        when(animal.getIsFly()).thenReturn(false);
//
//        assertTrue(animal.getAge() == 30);
//        assertTrue(animal.getName().equals("참새"));
//        assertTrue(animal.getIsFly() == false);

//        List<String> animalList = Arrays.asList("호랑이", "코끼리", "독수리");
//
//        when(animal.getAnimalList()).thenReturn(animalList);
//
//        assertNotNull(animalList);
//        assertEquals(animalList.size(), 3);
//
//        System.out.println(animal.getAnimalList().get(1));

//        doThrow(new RuntimeException())     // 메서드를 이용하여 예외를 발생시킬 수 있다.
//                .when(animal)
//                .setAge(eq(20));       // age == 20 일 때 예외 발생시켜라.
//        animal.setAge(20);

        animal.setName("참새");
        // 1번 호출 안했는지 체크
        verify(animal, times(1)).setName(any(String.class));
        // 호출 안했는지 체크
        verify(animal, never()).getName();      // success
        verify(animal, never()).setName(eq("호랑이"));      // success
        verify(animal, never()).setName(eq("호랑이2"));      // success

        // 최소한 1번 이상 호출했는지 체크
        verify(animal, atLeastOnce()).setName(any(String.class));
        // 2번 이하
        verify(animal, atMost(2)).setName(any(String.class));
        // 2번 이상
//        verify(animal, atLeast(2)).setName(any(String.class));
        // 지정된 시간 안으로 메서드를 호출했는지 체크
        verify(animal, timeout(100)).setName(any(String.class));
        verify(animal, timeout(100).atLeast(1)).setName(any(String.class));


    }
}
