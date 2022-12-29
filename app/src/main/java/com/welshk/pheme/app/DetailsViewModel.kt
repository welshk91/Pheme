package com.welshk.pheme.app

import androidx.lifecycle.ViewModel
import com.welshk.pheme.networking.ApplicationDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repository: ApplicationDataRepository) :
    ViewModel() {

}