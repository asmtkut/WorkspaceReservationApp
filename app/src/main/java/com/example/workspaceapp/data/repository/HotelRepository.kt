package com.example.workspaceapp.data.repository

import com.example.workspaceapp.data.model.Hotel

interface HotelRepository {
    /**
     * ホテル一覧を取得する
     * 通常はネットワークまたはローカルDBから取得
     * @return ホテルリスト
     * @throws Exception 通信や取得エラー時
     */
    @Throws(Exception::class)
    suspend fun getHotels(): List<Hotel>

    /**
     * 特定のホテルをIDで取得
     * @param id ホテルID
     * @return Hotelデータ（存在しない場合はnull）
     */
    suspend fun getHotelById(id: String): Hotel?
}
