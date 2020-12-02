package ca.wihraiech.mytestapp.di

import ca.wihraiech.mytestapp.api.RetrofitBuilder
import ca.wihraiech.mytestapp.api.service.ITestService
import ca.wihraiech.mytestapp.home.HomeViewModel
import ca.wihraiech.mytestapp.joke.JokedetailsViewModel
import ca.wihraiech.mytestapp.provider.IJokeProvider
import ca.wihraiech.mytestapp.provider.JokeProvider
import ca.wihraiech.mytestapp.useCase.FetchJokesUseCase
import ca.wihraiech.mytestapp.useCase.IFetchJokesUseCase
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

    factory<IJokeProvider> {
        JokeProvider(
            testService = get()
        )
    }

    factory<IFetchJokesUseCase> {
        FetchJokesUseCase(
            jokeProvider = get()
        )
    }

    viewModel {
        HomeViewModel(
            fetchJokesUseCase = get()
        )
    }

    viewModel {
        JokedetailsViewModel()
    }
}