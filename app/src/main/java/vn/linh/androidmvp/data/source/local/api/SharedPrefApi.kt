package vn.linh.androidmvp.data.source.local.api

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SharedPrefApi constructor(context: Context, private val gson: Gson) {
    private val sharedPreferences: SharedPreferences

    init {
        this.sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun putString(key: String, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getString(key: String, defaultValue: String?): String? {
        return sharedPreferences.getString(key, defaultValue)
    }

    fun putInt(key: String, value: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun getInt(key: String, defaultValue: Int): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    fun putFloat(key: String, value: Float) {
        val editor = sharedPreferences.edit()
        editor.putFloat(key, value)
        editor.apply()
    }

    fun getFloat(key: String, defaultValue: Float): Float {
        return sharedPreferences.getFloat(key, defaultValue)
    }

    fun putLong(key: String, value: Long) {
        val editor = sharedPreferences.edit()
        editor.putLong(key, value)
        editor.apply()
    }

    fun getLong(key: String, defaultValue: Long): Long {
        return sharedPreferences.getLong(key, defaultValue)
    }

    fun putDouble(key: String, value: Double) {
        putFloat(key, value.toFloat())
    }

    fun getDouble(key: String, doubleValue: Double): Double {
        return sharedPreferences.getFloat(key, doubleValue.toFloat()).toDouble()
    }

    fun putBoolean(key: String, value: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    fun <T> putObject(key: String, value: T) {
        val editor = sharedPreferences.edit()
        editor.putString(key, gson.toJson(value))
        editor.apply()
    }

    fun <T> getObject(key: String, clazz: Class<T>): T {
        return gson.fromJson(getString(key, null), clazz)
    }

    fun <T> putList(key: String, list: List<T>) {
        val editor = sharedPreferences.edit()
        editor.putString(key, gson.toJson(list))
        editor.apply()
    }

    fun <T> getList(key: String, clazz: Class<T>): List<T>? {
        val typeOfT = TypeToken.getParameterized(List::class.java, clazz).type
        return gson.fromJson<List<T>>(getString(key, null), typeOfT)
    }

    fun <T> putArray(key: String, arrays: Array<T>) {
        val editor = sharedPreferences.edit()
        editor.putString(key, gson.toJson(arrays))
        editor.apply()
    }

    fun <T> getArray(key: String, clazz: Class<Array<T>>): Array<T> {
        return gson.fromJson(getString(key, null), clazz)
    }

    fun removeKey(key: String) {
        val editor = sharedPreferences.edit()
        if (editor != null) {
            editor.remove(key)
            editor.apply()
        }
    }

    fun clear() {
        sharedPreferences.edit().clear().apply()
    }

    companion object {
        private val PREFS_NAME = "AndroidTestSharedPreferences"
        const val ACCESS_TOKEN = "ACCESS_TOKEN"
    }
}