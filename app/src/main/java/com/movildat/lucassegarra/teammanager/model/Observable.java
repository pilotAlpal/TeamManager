package com.movildat.lucassegarra.teammanager.model;

import android.content.pm.PackageInstaller;

/**
 * Created by Propietario on 12/08/2016.
 */

public interface Observable<T> {
    public void addObserver(T observer);
    public void delObserver(T observer);
}
