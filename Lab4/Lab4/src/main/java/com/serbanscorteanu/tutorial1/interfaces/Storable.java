package com.serbanscorteanu.tutorial1.interfaces;

import com.serbanscorteanu.tutorial1.customexceptions.StoreMethodException;

public interface Storable {
    void store(String file) throws StoreMethodException;
}
