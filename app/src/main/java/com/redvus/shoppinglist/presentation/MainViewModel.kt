package com.redvus.shoppinglist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.redvus.shoppinglist.data.ShoplistRepositoryImpl
import com.redvus.shoppinglist.domain.DeleteShopItemUseCase
import com.redvus.shoppinglist.domain.EditShopItemUseCase
import com.redvus.shoppinglist.domain.GetShopListUseCase
import com.redvus.shoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShoplistRepositoryImpl
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopListUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopListUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }

}