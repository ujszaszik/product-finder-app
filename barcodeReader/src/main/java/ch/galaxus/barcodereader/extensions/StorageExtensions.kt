package ch.galaxus.barcodereader.extensions

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings
import kotlin.math.min

private const val SYSTEM_STORAGE_THRESHOLD_PCT = "sys_storage_threshold_percentage"
private const val DEFAULT_STORAGE_THRESHOLD_PCT_INDEX = 5

private const val SYSTEM_STORAGE_MAX_THRESHOLD = "sys_storage_threshold_max_bytes"
private const val MAX_LOW_BYTES = 500L * 1_048_576

val Context.hasLowStorage: Boolean
    get() = usableBytes.lessOrEqualsThen(storageLowBytes)

private val Context.usableBytes: Long
    @SuppressLint("UsableSpace")
    get() = filesDir.usableSpace

private val Context.storageLowBytes: Long
    get() = min(lowBytes, maxLowBytes)

private val Context.lowBytes: Long
    get() = filesDir.totalSpace * lowPercent / 100

private val Context.lowPercent: Long
    get() = Settings.Global.getLong(
        contentResolver,
        SYSTEM_STORAGE_MAX_THRESHOLD,
        MAX_LOW_BYTES
    )

private val Context.maxLowBytes: Long
    get() = Settings.Global.getInt(
        contentResolver,
        SYSTEM_STORAGE_THRESHOLD_PCT,
        DEFAULT_STORAGE_THRESHOLD_PCT_INDEX
    ).toLong()