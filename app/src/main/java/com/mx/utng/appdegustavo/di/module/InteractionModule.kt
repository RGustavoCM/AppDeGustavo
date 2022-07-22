package com.mx.utng.appdegustavo.di.module

import com.mx.utng.appdegustavo.firebase.authentication.FirebaseAuthenticationInterface
import com.mx.utng.appdegustavo.firebase.authentication.FirebaseAuthenticationManager
import com.mx.utng.appdegustavo.firebase.database.FirebaseDatabaseInterface
import com.mx.utng.appdegustavo.firebase.database.FirebaseDatabaseManager
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [FirebaseModule::class])
@Singleton
abstract class InteractionModule {

  @Binds
  abstract fun authentication(authentication: FirebaseAuthenticationManager): FirebaseAuthenticationInterface

  @Binds
  abstract fun database(database: FirebaseDatabaseManager): FirebaseDatabaseInterface
}