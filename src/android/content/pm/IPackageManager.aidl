

package android.content.pm;

import android.content.ComponentName;
import android.content.Intent;

import android.content.pm.IPackageDataObserver;

import android.content.pm.IPackageStatsObserver;

import android.net.Uri;
import android.content.IntentSender;

/***
 *  See {@link PackageManager} for documentation on most of the APIs
 *  here.
 * 
 *  {@hide}
 */
interface IPackageManager {
    int getPackageUid(String packageName);
   
}
