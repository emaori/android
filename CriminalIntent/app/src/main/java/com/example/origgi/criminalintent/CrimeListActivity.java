package com.example.origgi.criminalintent;

import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by Emanuele on 30/04/2016.
 */
public class CrimeListActivity extends SingleFragmentActivity
        implements CrimeListFragment.Callbacks, CrimeFragment.Callbacks {
    
    @Override
    protected int getLayoutResId(){
        return R.layout.activity_masterdetail;
    }
    
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

    @Override
    public void onCrimeSelected(Crime crime) {
        // Per capire se si è su tablet controlla se l'id del fargment che si usa solo sul tablet è presente
        if(findViewById(R.id.detail_fragment_container)==null){
            // Phone
            Intent intent = CrimePagerActivity.newIntent(this, crime.getId());
            startActivity(intent);
        }else{
            // Tablet
            Fragment fragment = CrimeFragment.newInstance(crime.getId());

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_fragment_container, fragment)
                    .commit();
        }
    }

    @Override
    public void onCrimeUpdated(Crime crime) {
        // Aggiorna la lista di crimes
        CrimeListFragment listFragment = (CrimeListFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        listFragment.updateUI();
    }
}
