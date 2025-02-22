package com.example.desafiodimensa.di


//import org.koin.android.ext.koin.androidApplication
//import org.koin.androidx.viewmodel.dsl.viewModel
//import org.koin.dsl.module
//
//val daoModule = module {
//    single { DatabaseHelper.getInstance(androidApplication())?.userDao() }
//}
//
//val repositoryModule = module {
//
//    factory<UserRepository> {
//        UserRepositoryImpl(get())
//    }
//}
//
//val useCaseModule = module {
//    factory { ValidateEmailUseCase() }
//    factory { ValidatePasswordUseCase() }
//    factory { ValidateNameUseCase() }
//    factory { ValidateRepeatedPasswordUseCase() }
//
//    factory { AuthUseCase(get(), get(), get()) }
//    factory { RegisterUseCase(get(), get(), get(), get()) }
//}
//
//val viewModelModule = module {
//    viewModel { LoginViewModel(get(), get(), get()) }
//    viewModel { RegisterViewModel(get(), get(), get(), get(), get()) }
//}
