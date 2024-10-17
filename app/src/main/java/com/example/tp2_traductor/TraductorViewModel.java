package com.example.tp2_traductor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class TraductorViewModel extends ViewModel {
    private List<Palabra> palabraList;
    private MutableLiveData<String> palabraTraducida = new MutableLiveData<>();
    private MutableLiveData<Integer> imagen = new MutableLiveData<>();

    public TraductorViewModel() {
        palabraList = new ArrayList<>();
        palabraList.add(new Palabra("Gato", "Cat", R.drawable.gatito));
        palabraList.add(new Palabra("Perro", "Dog", R.drawable.perrito));
        palabraList.add(new Palabra("Casa", "House", R.drawable.casa));
        palabraList.add(new Palabra("Manzana", "Apple", R.drawable.manzana));
        palabraList.add(new Palabra("Conejo", "Rabbit", R.drawable.conejito));
    }

    public void Palabra (String palabraEsp) {
        for (Palabra palabra : palabraList) {
            if (palabra.getEspanol().equals(palabraEsp)) {
                palabraTraducida.setValue(palabra.getIngles());
                imagen.setValue(palabra.getImg());
                return;
            }
        }
        palabraTraducida.setValue("No Eencontrada");
        imagen.setValue(R.drawable.nada1);
    }

    public LiveData<String> getPalabraTraducida() {
        return palabraTraducida;
    }

    public LiveData<Integer> getImagen() {
        return imagen;
    }
}
