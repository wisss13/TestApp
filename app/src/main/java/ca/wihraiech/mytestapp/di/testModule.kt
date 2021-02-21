package ca.wihraiech.mytestapp.di

import ca.wihraiech.mytestapp.api.RetrofitBuilder
import ca.wihraiech.mytestapp.api.service.ITestService
import ca.wihraiech.mytestapp.home.HomeViewModel
import ca.wihraiech.mytestapp.joke.JokedetailsViewModel
import ca.wihraiech.mytestapp.paging.JokeDataSource
import ca.wihraiech.mytestapp.provider.IJokeProvider
import ca.wihraiech.mytestapp.provider.IUserProvider
import ca.wihraiech.mytestapp.provider.JokeProvider
import ca.wihraiech.mytestapp.provider.UserProvider
import ca.wihraiech.mytestapp.repository.JokeRepository
import ca.wihraiech.mytestapp.repository.UserRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Application modules injected into app
 */
@ExperimentalCoroutinesApi
val testModule: Module = module {

    single {
        RetrofitBuilder().build()
            .create(ITestService::class.java)
    }

    factory {
        JokeDataSource(
            userProvider = get()
        )
    }

    factory {
        UserRepository(
            jokeDataSource = get()
        )
    }

    factory {
        JokeRepository(
            jokeProvider = get()
        )
    }

    factory<IJokeProvider> {
        JokeProvider(
            testService = get()
        )
    }

    factory<IUserProvider> {
        UserProvider(
            testService = get()
        )
    }

    viewModel {
        HomeViewModel(
            userRepository = get()
        )
    }

    viewModel {
        JokedetailsViewModel()
    }
}