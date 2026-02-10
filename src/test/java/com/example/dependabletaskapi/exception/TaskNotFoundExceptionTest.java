package com.example.dependabletaskapi.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskNotFoundExceptionTest {

    @Test
    void testExceptionMessage() {
        Long taskId = 123L;
        TaskNotFoundException exception = new TaskNotFoundException(taskId);
        
        assertNotNull(exception.getMessage());
        assertTrue(exception.getMessage().contains("123"));
        assertTrue(exception.getMessage().contains("not found"));
    }

    @Test
    void testExceptionMessageWithDifferentIds() {
        TaskNotFoundException exception1 = new TaskNotFoundException(1L);
        TaskNotFoundException exception2 = new TaskNotFoundException(999L);
        
        assertTrue(exception1.getMessage().contains("1"));
        assertTrue(exception2.getMessage().contains("999"));
        assertNotEquals(exception1.getMessage(), exception2.getMessage());
    }

    @Test
    void testExceptionIsRuntimeException() {
        TaskNotFoundException exception = new TaskNotFoundException(1L);
        assertInstanceOf(RuntimeException.class, exception);
    }

    @Test
    void testExceptionCanBeThrown() {
        assertThrows(TaskNotFoundException.class, () -> {
            throw new TaskNotFoundException(42L);
        });
    }

    @Test
    void testExceptionMessage_containsExpectedFormat() {
        TaskNotFoundException exception = new TaskNotFoundException(100L);
        String message = exception.getMessage();
        
        assertTrue(message.startsWith("Task not found:"));
        assertTrue(message.contains("100"));
    }
}
