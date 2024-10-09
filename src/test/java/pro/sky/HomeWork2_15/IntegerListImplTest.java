package pro.sky.HomeWork2_15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.HomeWork2_15.exception.ElementNotFoundException;
import pro.sky.HomeWork2_15.exception.FullStorageException;
import pro.sky.HomeWork2_15.exception.NullItemException;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {

    @Test
    public void testAddElement() {
        IntegerList list = new IntegerListImpl();
        assertEquals(0, list.size());
        list.add(5);
        assertEquals(1, list.size());
        assertEquals(5, list.get(0));
    }

    @Test
    public void testAddAtSpecificIndex() {
        IntegerList list = new IntegerListImpl();
        list.add(1);
        list.add(2);
        list.add(1, 3); // Insert 3 at index 1
        assertEquals(3, list.get(1));
        assertEquals(2, list.get(2));
    }

    @Test
    public void testSetElement() {
        IntegerList list = new IntegerListImpl();
        list.add(1);
        list.set(0, 2); // Set first element to 2
        assertEquals(2, list.get(0));
    }


    @Test
    public void testAddNullElement() {
        IntegerList list = new IntegerListImpl();
        assertThrows(NullItemException.class, () -> {
            list.add(null);
        });
    }

    @Test
    public void testAddBeyondCapacity() {
        IntegerList list = new IntegerListImpl(2);
        list.add(1);
        list.add(2);
        assertThrows(FullStorageException.class, () -> {
            list.add(3);
        });
    }

    @Test
    public void testRemoveNonExistentElement() {
        IntegerList list = new IntegerListImpl();
        assertThrows(ElementNotFoundException.class, () -> {
            list.remove(Integer.valueOf(99));
        });
    }
}