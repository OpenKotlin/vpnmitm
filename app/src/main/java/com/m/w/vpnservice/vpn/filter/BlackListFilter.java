package com.m.w.vpnservice.vpn.filter;

import android.util.Log;
import android.util.SparseIntArray;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by zengzheying on 16/1/6.
 */
public class BlackListFilter implements DomainFilter {

    private Map<String, Integer> mDomainMap = new HashMap<>();
    private SparseIntArray mIpMask = new SparseIntArray();

    @Override
    public void prepare() {

		/*/if (mDomainMap.size() != 0 || mIpMask.size() != 0) {
			return;
		}

		InputStream in = getHostInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				line = line.trim();
				if (line.startsWith("#")
						|| !TextUtils.isDigitsOnly(String.valueOf(line.charAt(0)))) {
					continue;
				}

				String[] parts = line.split(" ");
				if (parts.length == 2
						&& !"localhost".equalsIgnoreCase(parts[1])) {
					String ipStr = parts[0];
					int ip = CommonMethods.ipStringToInt(ipStr);
					mDomainMap.put(parts[1], ip);
					mIpMask.put(ip, 1);
				}
			}
		} catch (IOException ex) {

		} finally {
			try {
				reader.close();
				in.close();
			} catch (IOException ex) {

			}
		}/*/
    }

    @Override
    public boolean needFilter(String domain, int ip) {
        Log.d("Tanck", "过滤网站:" + domain + ", ip:" + ip);
        return false;
		/*/if (domain == null) {
			return false;
		}

		boolean filter = false;
		if (mipmask.get(ip, -1) == 1) {
			filter = true;
		}
		if (pattern.matches("\\d+\\.\\d+\\.\\d+\\.\\d+", domain.trim())) {
			int newip = commonmethods.ipstringtoint(domain.trim());
			filter = filter || (mipmask.get(newip, -1) == 1);
		}
		string key = domain.trim();
		if (mdomainmap.containskey(key)) {
			filter = true;
			int oldip = mdomainmap.get(key);
			if (!proxyconfig.isfakeip(ip) && ip != oldip) {
				mdomainmap.put(key, ip);
				mipmask.put(ip, 1);
			}
		}

		return filter;/*/
    }

	/*/private InputStream getHostInputStream() {
		InputStream in = null;
		Context context = GlobalApplication.getInstance();
		File file = new File(context.getExternalCacheDir(), "host.txt");
		if (file.exists()) {
			try {
				in = new FileInputStream(file);
			} catch (IOException ex) {
				if (AppDebug.IS_DEBUG) {
					ex.printStackTrace(System.err);
				}
			}
		}
		if (in == null) {
			in = context.getResources().openRawResource(R.raw.hosts);
		}
		return in;
	}/*/
}
