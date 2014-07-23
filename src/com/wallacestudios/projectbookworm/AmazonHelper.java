package com.wallacestudios.projectbookworm;

import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.authorization.api.AmazonAuthorizationManager;
import com.amazon.identity.auth.device.authorization.api.AuthorizationListener;
import com.amazon.identity.auth.device.authorization.api.AuthzConstants;
import com.amazon.identity.auth.device.shared.APIListener;

import android.util.Log;
import android.text.TextUtils;
import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;


import android.widget.Toast;
import android.view.View.OnClickListener;



public class AmazonHelper {

	private String userName;
	private String userQuery;	//in place for user to search Amazon wish list items to check availability at DPL
	private AmazonAuthorizationManager userAuthManager;
	
	public AmazonHelper()
	{}
}
