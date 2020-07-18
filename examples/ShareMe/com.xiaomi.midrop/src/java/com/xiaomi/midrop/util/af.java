/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Bundle
 *  android.text.TextUtils
 *  com.google.firebase.analytics.FirebaseAnalytics
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.xiaomi.midrop.util;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.xiaomi.midrop.util.aa;
import com.xiaomi.midrop.util.k;
import org.json.JSONException;
import org.json.JSONObject;

public final class af {
    private a a;
    private Bundle b = new Bundle();
    private JSONObject c = new JSONObject();

    private af(a a2) {
        this.a = a2;
    }

    public static af a(a a2) {
        return new af(a2);
    }

    public static void a(Intent intent) {
        if (intent == null) {
            return;
        }
        String string2 = intent.getStringExtra("entrance_id");
        if (TextUtils.isEmpty((CharSequence)string2)) {
            string2 = intent.getSourceBounds() != null ? "LauncherIcon" : "Other";
        }
        af.a(string2);
    }

    public static void a(String string2) {
        af.a(a.l).a(b.l, string2).a(b.x, Build.MANUFACTURER).a();
    }

    public final af a(b b2, int n2) {
        this.b.putInt(b2.aG, n2);
        try {
            this.c.put(b2.aG, n2);
            return this;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return this;
        }
    }

    public final af a(b b2, String string2) {
        this.b.putString(b2.aG, string2);
        try {
            this.c.put(b2.aG, (Object)string2);
            return this;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return this;
        }
    }

    public final void a() {
        if (!aa.a()) {
            k k2 = k.a();
            String string2 = this.a.dY;
            Bundle bundle = this.b;
            k2.a.logEvent(string2, bundle);
        }
    }

    /*
     * Illegal identifiers - consider using --renameillegalidents true
     */
    public static final class a
    extends Enum<a> {
        public static final /* enum */ a A;
        public static final /* enum */ a B;
        public static final /* enum */ a C;
        public static final /* enum */ a D;
        public static final /* enum */ a E;
        public static final /* enum */ a F;
        public static final /* enum */ a G;
        public static final /* enum */ a H;
        public static final /* enum */ a I;
        public static final /* enum */ a J;
        public static final /* enum */ a K;
        public static final /* enum */ a L;
        public static final /* enum */ a M;
        public static final /* enum */ a N;
        public static final /* enum */ a O;
        public static final /* enum */ a P;
        public static final /* enum */ a Q;
        public static final /* enum */ a R;
        public static final /* enum */ a S;
        public static final /* enum */ a T;
        public static final /* enum */ a U;
        public static final /* enum */ a V;
        public static final /* enum */ a W;
        public static final /* enum */ a X;
        public static final /* enum */ a Y;
        public static final /* enum */ a Z;
        public static final /* enum */ a a;
        public static final /* enum */ a aA;
        public static final /* enum */ a aB;
        public static final /* enum */ a aC;
        public static final /* enum */ a aD;
        public static final /* enum */ a aE;
        public static final /* enum */ a aF;
        public static final /* enum */ a aG;
        public static final /* enum */ a aH;
        public static final /* enum */ a aI;
        public static final /* enum */ a aJ;
        public static final /* enum */ a aK;
        public static final /* enum */ a aL;
        public static final /* enum */ a aM;
        public static final /* enum */ a aN;
        public static final /* enum */ a aO;
        public static final /* enum */ a aP;
        public static final /* enum */ a aQ;
        public static final /* enum */ a aR;
        public static final /* enum */ a aS;
        public static final /* enum */ a aT;
        public static final /* enum */ a aU;
        public static final /* enum */ a aV;
        public static final /* enum */ a aW;
        public static final /* enum */ a aX;
        public static final /* enum */ a aY;
        public static final /* enum */ a aZ;
        public static final /* enum */ a aa;
        public static final /* enum */ a ab;
        public static final /* enum */ a ac;
        public static final /* enum */ a ad;
        public static final /* enum */ a ae;
        public static final /* enum */ a af;
        public static final /* enum */ a ag;
        public static final /* enum */ a ah;
        public static final /* enum */ a ai;
        public static final /* enum */ a aj;
        public static final /* enum */ a ak;
        public static final /* enum */ a al;
        public static final /* enum */ a am;
        public static final /* enum */ a an;
        public static final /* enum */ a ao;
        public static final /* enum */ a ap;
        public static final /* enum */ a aq;
        public static final /* enum */ a ar;
        public static final /* enum */ a as;
        public static final /* enum */ a at;
        public static final /* enum */ a au;
        public static final /* enum */ a av;
        public static final /* enum */ a aw;
        public static final /* enum */ a ax;
        public static final /* enum */ a ay;
        public static final /* enum */ a az;
        public static final /* enum */ a b;
        public static final /* enum */ a bA;
        public static final /* enum */ a bB;
        public static final /* enum */ a bC;
        public static final /* enum */ a bD;
        public static final /* enum */ a bE;
        public static final /* enum */ a bF;
        public static final /* enum */ a bG;
        public static final /* enum */ a bH;
        public static final /* enum */ a bI;
        public static final /* enum */ a bJ;
        public static final /* enum */ a bK;
        public static final /* enum */ a bL;
        public static final /* enum */ a bM;
        public static final /* enum */ a bN;
        public static final /* enum */ a bO;
        public static final /* enum */ a bP;
        public static final /* enum */ a bQ;
        public static final /* enum */ a bR;
        public static final /* enum */ a bS;
        public static final /* enum */ a bT;
        public static final /* enum */ a bU;
        public static final /* enum */ a bV;
        public static final /* enum */ a bW;
        public static final /* enum */ a bX;
        public static final /* enum */ a bY;
        public static final /* enum */ a bZ;
        public static final /* enum */ a ba;
        public static final /* enum */ a bb;
        public static final /* enum */ a bc;
        public static final /* enum */ a bd;
        public static final /* enum */ a be;
        public static final /* enum */ a bf;
        public static final /* enum */ a bg;
        public static final /* enum */ a bh;
        public static final /* enum */ a bi;
        public static final /* enum */ a bj;
        public static final /* enum */ a bk;
        public static final /* enum */ a bl;
        public static final /* enum */ a bm;
        public static final /* enum */ a bn;
        public static final /* enum */ a bo;
        public static final /* enum */ a bp;
        public static final /* enum */ a bq;
        public static final /* enum */ a br;
        public static final /* enum */ a bs;
        public static final /* enum */ a bt;
        public static final /* enum */ a bu;
        public static final /* enum */ a bv;
        public static final /* enum */ a bw;
        public static final /* enum */ a bx;
        public static final /* enum */ a by;
        public static final /* enum */ a bz;
        public static final /* enum */ a c;
        public static final /* enum */ a cA;
        public static final /* enum */ a cB;
        public static final /* enum */ a cC;
        public static final /* enum */ a cD;
        public static final /* enum */ a cE;
        public static final /* enum */ a cF;
        public static final /* enum */ a cG;
        public static final /* enum */ a cH;
        public static final /* enum */ a cI;
        public static final /* enum */ a cJ;
        public static final /* enum */ a cK;
        public static final /* enum */ a cL;
        public static final /* enum */ a cM;
        public static final /* enum */ a cN;
        public static final /* enum */ a cO;
        public static final /* enum */ a cP;
        public static final /* enum */ a cQ;
        public static final /* enum */ a cR;
        public static final /* enum */ a cS;
        public static final /* enum */ a cT;
        public static final /* enum */ a cU;
        public static final /* enum */ a cV;
        public static final /* enum */ a cW;
        public static final /* enum */ a cX;
        public static final /* enum */ a cY;
        public static final /* enum */ a cZ;
        public static final /* enum */ a ca;
        public static final /* enum */ a cb;
        public static final /* enum */ a cc;
        public static final /* enum */ a cd;
        public static final /* enum */ a ce;
        public static final /* enum */ a cf;
        public static final /* enum */ a cg;
        public static final /* enum */ a ch;
        public static final /* enum */ a ci;
        public static final /* enum */ a cj;
        public static final /* enum */ a ck;
        public static final /* enum */ a cl;
        public static final /* enum */ a cm;
        public static final /* enum */ a cn;
        public static final /* enum */ a co;
        public static final /* enum */ a cp;
        public static final /* enum */ a cq;
        public static final /* enum */ a cr;
        public static final /* enum */ a cs;
        public static final /* enum */ a ct;
        public static final /* enum */ a cu;
        public static final /* enum */ a cv;
        public static final /* enum */ a cw;
        public static final /* enum */ a cx;
        public static final /* enum */ a cy;
        public static final /* enum */ a cz;
        public static final /* enum */ a d;
        public static final /* enum */ a dA;
        public static final /* enum */ a dB;
        public static final /* enum */ a dC;
        public static final /* enum */ a dD;
        public static final /* enum */ a dE;
        public static final /* enum */ a dF;
        public static final /* enum */ a dG;
        public static final /* enum */ a dH;
        public static final /* enum */ a dI;
        public static final /* enum */ a dJ;
        public static final /* enum */ a dK;
        public static final /* enum */ a dL;
        public static final /* enum */ a dM;
        public static final /* enum */ a dN;
        public static final /* enum */ a dO;
        public static final /* enum */ a dP;
        public static final /* enum */ a dQ;
        public static final /* enum */ a dR;
        public static final /* enum */ a dS;
        public static final /* enum */ a dT;
        public static final /* enum */ a dU;
        public static final /* enum */ a dV;
        public static final /* enum */ a dW;
        public static final /* enum */ a dX;
        private static final /* synthetic */ a[] dZ;
        public static final /* enum */ a da;
        public static final /* enum */ a db;
        public static final /* enum */ a dc;
        public static final /* enum */ a dd;
        public static final /* enum */ a de;
        public static final /* enum */ a df;
        public static final /* enum */ a dg;
        public static final /* enum */ a dh;
        public static final /* enum */ a di;
        public static final /* enum */ a dj;
        public static final /* enum */ a dk;
        public static final /* enum */ a dl;
        public static final /* enum */ a dm;
        public static final /* enum */ a dn;
        public static final /* enum */ a do;
        public static final /* enum */ a dp;
        public static final /* enum */ a dq;
        public static final /* enum */ a dr;
        public static final /* enum */ a ds;
        public static final /* enum */ a dt;
        public static final /* enum */ a du;
        public static final /* enum */ a dv;
        public static final /* enum */ a dw;
        public static final /* enum */ a dx;
        public static final /* enum */ a dy;
        public static final /* enum */ a dz;
        public static final /* enum */ a e;
        public static final /* enum */ a f;
        public static final /* enum */ a g;
        public static final /* enum */ a h;
        public static final /* enum */ a i;
        public static final /* enum */ a j;
        public static final /* enum */ a k;
        public static final /* enum */ a l;
        public static final /* enum */ a m;
        public static final /* enum */ a n;
        public static final /* enum */ a o;
        public static final /* enum */ a p;
        public static final /* enum */ a q;
        public static final /* enum */ a r;
        public static final /* enum */ a s;
        public static final /* enum */ a t;
        public static final /* enum */ a u;
        public static final /* enum */ a v;
        public static final /* enum */ a w;
        public static final /* enum */ a x;
        public static final /* enum */ a y;
        public static final /* enum */ a z;
        private String dY;

        static {
            a = new a("click_received_icon");
            b = new a("click_setting_entrance");
            c = new a("click_setting_language");
            d = new a("click_setting_privacy_policy");
            e = new a("click_setting_agreement");
            f = new a("click_setting_version");
            g = new a("About_Click");
            h = new a("click_setting_hidden_file");
            i = new a("click_share");
            j = new a("click_send");
            k = new a("click_receive");
            l = new a("app_start_with_entrance");
            m = new a("click_set_name");
            n = new a("click_custom_name_saved");
            o = new a("click_score");
            p = new a("click_feedback");
            q = new a("show_score_dialog");
            r = new a("score_selected");
            s = new a("score_dialog_click_ok");
            t = new a("show_request_permissions_dialog");
            u = new a("request_permissions_dialog_setup");
            v = new a("request_permissions_dialog_cancel");
            w = new a("show_request_write_settings_permission");
            x = new a("write_settings_permission_granted");
            y = new a("click_send_back_icon");
            z = new a("click_send_recent");
            A = new a("click_send_image");
            B = new a("click_send_video");
            C = new a("click_send_music");
            D = new a("click_send_app");
            E = new a("click_send_dir");
            F = new a("click_send_file");
            G = new a("click_selected_icon");
            H = new a("click_send_any");
            I = new a("click_delete_all");
            J = new a("click_delete_single");
            K = new a("click_exit_select_files");
            L = new a("click_send_exit_show_confirm");
            M = new a("scroll_image_group_page");
            N = new a("scroll_music_group_page");
            O = new a("click_image_preview");
            P = new a("click_video_preview");
            Q = new a("click_music_preview");
            R = new a("connect_succeeded");
            S = new a("connect_failed");
            T = new a("conn_p2p_succeed");
            U = new a("conn_p2p_fail");
            V = new a("conn_xmpp_start_fail");
            W = new a("conn_xmpp_conn_fail");
            X = new a("conn_xmpp_conn_succeed");
            Y = new a("conn_ap_create_fail");
            Z = new a("ap_conn_ap_create_fail");
            aa = new a("ap_conn_xmpp_start_fail");
            ab = new a("bt_connect_succeed");
            ac = new a("bt_connect_failed");
            ad = new a("bt_connect_time");
            ae = new a("bt_connect_fail_time");
            af = new a("bt_start_server_failed");
            ag = new a("bt_listen_succeed");
            ah = new a("bt_listen_failed");
            ai = new a("bt_start_not_enabled");
            aj = new a("bt_accept_succeed");
            ak = new a("bt_accept_failed");
            al = new a("bt_conn_ap_exist");
            am = new a("bt_conn_ap_not_exist");
            an = new a("exit_send_procedure");
            ao = new a("click_reconnect_send");
            ap = new a("click_retry");
            aq = new a("click_share_from_send");
            ar = new a("detect_receiver");
            as = new a("click_send_more");
            at = new a("sender_receive_accept");
            au = new a("send_success");
            av = new a("send_fail");
            aw = new a("send_download_cancel");
            ax = new a("sender_show_abort_send_dialog");
            ay = new a("sending_show_delete_file_dialog");
            az = new a("sending_delete_file_confirmed");
            aA = new a("sender_exit_send");
            aB = new a("send_all_success");
            aC = new a("show_receive_dialog");
            aD = new a("accept_receive");
            aE = new a("reject_receive");
            aF = new a("exit_receive_procedure");
            aG = new a("click_reconnect_receive");
            aH = new a("click_receive_more");
            aI = new a("receive_success");
            aJ = new a("receive_fail");
            aK = new a("receive_download_cancel");
            aL = new a("receive_show_exit_dialog");
            aM = new a("receive_show_delete_file_dialog");
            aN = new a("receive_delete_file_confirmed");
            aO = new a("receive_all_success");
            aP = new a("click_receive_any");
            aQ = new a("click_receive_image");
            aR = new a("click_receive_video");
            aS = new a("click_receive_music");
            aT = new a("click_receive_apk");
            aU = new a("click_receive_file");
            aV = new a("click_receive_image_preview");
            aW = new a("click_receive_video_preview");
            aX = new a("click_receive_music_preview");
            aY = new a("click_receive_apk_preview");
            aZ = new a("click_receive_file_preview");
            ba = new a("click_receive_folder");
            bb = new a("click_setting_connect_to_computer");
            bc = new a("click_start_ftp_server");
            bd = new a("click_ftp_settings");
            be = new a("ftp_receive_file");
            bf = new a("ftp_send_file");
            bg = new a("click_choose_storage_location");
            bh = new a("choose_storage_sd_card");
            bi = new a("event_share_show_fb");
            bj = new a("event_share_show_whatsapp");
            bk = new a("event_click_any_share");
            bl = new a("event_click_wifi_ap_share");
            bm = new a("event_click_bt_share");
            bn = new a("event_click_share_via_bluetooth");
            bo = new a("event_click_whatsapp_share");
            bp = new a("event_click_fb_share");
            bq = new a("event_click_qr_share");
            br = new a("event_click_more_share");
            bs = new a("event_share_to_fb_success");
            bt = new a("event_using_wifi_ap_share_success");
            bu = new a("event_share_page");
            bv = new a("file_select_entrance");
            bw = new a("finished_transferring_total_count");
            bx = new a("operation_activity_dialog_show");
            by = new a("operation_activity_dialog_click");
            bz = new a("operation_activity_dialog_close_click");
            bA = new a("operation_activity_icon_show");
            bB = new a("operation_activity_icon_click");
            bC = new a("operation_activity_toast_show");
            bD = new a("operation_activity_toast_click");
            bE = new a("dev_activity_no_region");
            bF = new a("d_act_cor_fetched_and_should_show");
            bG = new a("d_act_cor_fetched_and_should_show_tip");
            bH = new a("dev_activity_corner_img_loaded");
            bI = new a("d_act_dia_fetched_and_should_show");
            bJ = new a("dev_activity_dialog_imgs_loaded");
            bK = new a("Result_OP_Show");
            bL = new a("Result_OP_Click");
            bM = new a("dev_cloud_settings_request");
            bN = new a("dev_cloud_settings_response");
            bO = new a("dev_cloud_settings_failed");
            bP = new a("open_search");
            bQ = new a("search_result_ok");
            bR = new a("search_result_non");
            bS = new a("search_choose_result");
            bT = new a("trans_file_type_count");
            bU = new a("trans_view_more_pictures");
            bV = new a("trans_click_successful_item");
            bW = new a("trans_click_successful_item_in_more");
            bX = new a("ap_share_started");
            bY = new a("ap_share_connected");
            bZ = new a("ap_share_click_next");
            ca = new a("ap_share_downloading");
            cb = new a("received_open_edit");
            cc = new a("received_edit_delete");
            cd = new a("received_edit_delete_confirm");
            ce = new a("received_close_edit");
            cf = new a("Enter_Homepage");
            cg = new a("Enter_ScanPage");
            ch = new a("Scan_Anyone_new");
            ci = new a("Leave_ScanPage");
            cj = new a("Click_Portrait");
            ck = new a("Connect_Start");
            cl = new a("Connect_Succeed_ap");
            cm = new a("Communicate_Succeed_bt");
            cn = new a("Agree_Transfer_ap");
            co = new a("Agree_Connect_bt");
            cp = new a("Connect_Succeed_btap");
            cq = new a("Connect_Success");
            cr = new a("Connect_Failure");
            cs = new a("Start_Transfer_FromConnectProgress");
            ct = new a("Transfer_Success_Sender");
            cu = new a("Transfer_Success_Receiver");
            cv = new a("Transfer_Success");
            cw = new a("Transfer_All_Success");
            cx = new a("Transfer_Speed_KB_2GHz");
            cy = new a("Transfer_Speed_KB_5GHz");
            cz = new a("Enter_FileSelect_SomePage");
            cA = new a("SelectFile_FileSelect_SomePage");
            cB = new a("Connect_Succeed_bt");
            cC = new a("S_Bt_Connect_Start");
            cD = new a("S_Bt_Connect_Succeed");
            cE = new a("S_Bt_Connect_Failed");
            cF = new a("Enter_ScanPage_NewUser");
            cG = new a("Scan_Anyone_NewUser");
            cH = new a("Enter_ScanPage_OldUser");
            cI = new a("Scan_Anyone_OldUser");
            cJ = new a("Enter_ScanPage_FileSize");
            cK = new a("Click_Send_FileDetail");
            cL = new a("Click_Send_AppDetail");
            cM = new a("auto_receive_midrop_start");
            cN = new a("auto_receive_midrop_success");
            cO = new a("show_upgrade_midrop_dialog");
            cP = new a("click_upgrade_midrop");
            cQ = new a("close_auto_receive_midrop");
            cR = new a("no_data_up_show_message");
            cS = new a("no_data_up_use");
            cT = new a("no_data_up_agree");
            cU = new a("no_data_up_show_select_list");
            cV = new a("no_data_up_close_waiting_dialog");
            cW = new a("no_data_up_get");
            cX = new a("no_data_up_close_setting_switch");
            cY = new a("Server_Update_Check");
            cZ = new a("Server_Update_FindNew");
            da = new a("Server_UpdatePOP_Show");
            db = new a("Server_UpdatePOP_ClickOK");
            dc = new a("Server_Update_MaxReminder");
            dd = new a("Result_enter");
            de = new a("Result_close");
            df = new a("Result_transfer_show");
            dg = new a("Result_transfer_share");
            dh = new a("Result_transfer_share_ok");
            di = new a("Result_received_show");
            dj = new a("Result_received_click");
            dk = new a("Result_score_show");
            dl = new a("Result_score_click");
            dm = new a("Result_score_click_ok");
            dn = new a("Result_silence_install_show");
            do = new a("Result_silence_install_click");
            dp = new a("total_distinct_trans_times");
            dq = new a("day_distinct_trans_times");
            dr = new a("event_4g_update_pop_show");
            ds = new a("event_4g_update_open");
            dt = new a("QRConnect_Scan_Click");
            du = new a("QRConnect_ScanRMPOP_Show");
            dv = new a("QRConnect_ScanRMPOP_Go");
            dw = new a("QRConnect_ScanPage_Enter");
            dx = new a("QRConnect_ConnectPage_Enter");
            dy = new a("QRConnect_ConnectPage_Success");
            dz = new a("QRConnect_ConnectPage_Fail");
            dA = new a("CameraPermission_POP_Show");
            dB = new a("CameraPermission_POP_Go");
            dC = new a("QRConnect_QRRMPOP_Show");
            dD = new a("Transfer_open_file_prompt_continue");
            dE = new a("MenuInfo_Portrait_Click");
            dF = new a("click_custom_name_saved");
            dG = new a("MenuInfo_ExitRemind_Next");
            dH = new a("StartPage_Show");
            dI = new a("StartPage_Start_Click");
            dJ = new a("StartPage_Link_Click");
            dK = new a("FirstInfo_Enter");
            dL = new a("FirstInfo_Portrait_Click");
            dM = new a("FirstInfo_Next_Homepage");
            dN = new a("MenuInfo_ExitRemind_Show");
            dO = new a("midrop_transfer_duration");
            dP = new a("webshare_funnel");
            dQ = new a("Trans_InProFile");
            dR = new a("Trans_TransferedFile");
            dS = new a("Common_data");
            dT = new a("Enter_FIle_Selection_page_new");
            dU = new a("connection_timeout_toast");
            dV = new a("connect_success_timeout_error_code");
            dW = new a("korea_permission_page");
            dX = new a("Common_data");
            a[] arra = new a[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, aa, ab, ac, ad, ae, af, ag, ah, ai, aj, ak, al, am, an, ao, ap, aq, ar, as, at, au, av, aw, ax, ay, az, aA, aB, aC, aD, aE, aF, aG, aH, aI, aJ, aK, aL, aM, aN, aO, aP, aQ, aR, aS, aT, aU, aV, aW, aX, aY, aZ, ba, bb, bc, bd, be, bf, bg, bh, bi, bj, bk, bl, bm, bn, bo, bp, bq, br, bs, bt, bu, bv, bw, bx, by, bz, bA, bB, bC, bD, bE, bF, bG, bH, bI, bJ, bK, bL, bM, bN, bO, bP, bQ, bR, bS, bT, bU, bV, bW, bX, bY, bZ, ca, cb, cc, cd, ce, cf, cg, ch, ci, cj, ck, cl, cm, cn, co, cp, cq, cr, cs, ct, cu, cv, cw, cx, cy, cz, cA, cB, cC, cD, cE, cF, cG, cH, cI, cJ, cK, cL, cM, cN, cO, cP, cQ, cR, cS, cT, cU, cV, cW, cX, cY, cZ, da, db, dc, dd, de, df, dg, dh, di, dj, dk, dl, dm, dn, do, dp, dq, dr, ds, dt, du, dv, dw, dx, dy, dz, dA, dB, dC, dD, dE, dF, dG, dH, dI, dJ, dK, dL, dM, dN, dO, dP, dQ, dR, dS, dT, dU, dV, dW, dX};
            dZ = arra;
        }

        private a(String string3) {
            this.dY = string3;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])dZ.clone();
        }
    }

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b A;
        public static final /* enum */ b B;
        public static final /* enum */ b C;
        public static final /* enum */ b D;
        public static final /* enum */ b E;
        public static final /* enum */ b F;
        public static final /* enum */ b G;
        public static final /* enum */ b H;
        public static final /* enum */ b I;
        public static final /* enum */ b J;
        public static final /* enum */ b K;
        public static final /* enum */ b L;
        public static final /* enum */ b M;
        public static final /* enum */ b N;
        public static final /* enum */ b O;
        public static final /* enum */ b P;
        public static final /* enum */ b Q;
        public static final /* enum */ b R;
        public static final /* enum */ b S;
        public static final /* enum */ b T;
        public static final /* enum */ b U;
        public static final /* enum */ b V;
        public static final /* enum */ b W;
        public static final /* enum */ b X;
        public static final /* enum */ b Y;
        public static final /* enum */ b Z;
        public static final /* enum */ b a;
        public static final /* enum */ b aA;
        public static final /* enum */ b aB;
        public static final /* enum */ b aC;
        public static final /* enum */ b aD;
        public static final /* enum */ b aE;
        public static final /* enum */ b aF;
        private static final /* synthetic */ b[] aH;
        public static final /* enum */ b aa;
        public static final /* enum */ b ab;
        public static final /* enum */ b ac;
        public static final /* enum */ b ad;
        public static final /* enum */ b ae;
        public static final /* enum */ b af;
        public static final /* enum */ b ag;
        public static final /* enum */ b ah;
        public static final /* enum */ b ai;
        public static final /* enum */ b aj;
        public static final /* enum */ b ak;
        public static final /* enum */ b al;
        public static final /* enum */ b am;
        public static final /* enum */ b an;
        public static final /* enum */ b ao;
        public static final /* enum */ b ap;
        public static final /* enum */ b aq;
        public static final /* enum */ b ar;
        public static final /* enum */ b as;
        public static final /* enum */ b at;
        public static final /* enum */ b au;
        public static final /* enum */ b av;
        public static final /* enum */ b aw;
        public static final /* enum */ b ax;
        public static final /* enum */ b ay;
        public static final /* enum */ b az;
        public static final /* enum */ b b;
        public static final /* enum */ b c;
        public static final /* enum */ b d;
        public static final /* enum */ b e;
        public static final /* enum */ b f;
        public static final /* enum */ b g;
        public static final /* enum */ b h;
        public static final /* enum */ b i;
        public static final /* enum */ b j;
        public static final /* enum */ b k;
        public static final /* enum */ b l;
        public static final /* enum */ b m;
        public static final /* enum */ b n;
        public static final /* enum */ b o;
        public static final /* enum */ b p;
        public static final /* enum */ b q;
        public static final /* enum */ b r;
        public static final /* enum */ b s;
        public static final /* enum */ b t;
        public static final /* enum */ b u;
        public static final /* enum */ b v;
        public static final /* enum */ b w;
        public static final /* enum */ b x;
        public static final /* enum */ b y;
        public static final /* enum */ b z;
        private String aG;

        static {
            a = new b("send_image_count");
            b = new b("send_music_count");
            c = new b("send_video_count");
            d = new b("send_app_count");
            e = new b("send_other_count");
            f = new b("connect_count");
            g = new b("category_count");
            h = new b("send_directory_count");
            i = new b("send_file_scene");
            j = new b("send_duration_time");
            k = new b("connect_fail_times");
            l = new b("entrance_id");
            m = new b("request_permission_scene");
            n = new b("event_name");
            o = new b("score_value");
            p = new b("file_select_entrance");
            q = new b("transferring_total_count");
            r = new b("send_more_status");
            s = new b("connect_type");
            t = new b("connect_duration_time");
            u = new b("connect_ap_type");
            v = new b("connect_ap_band_type");
            w = new b("connect_high_speed");
            x = new b("manufacturer_name");
            y = new b("activity_id");
            z = new b("os_version");
            A = new b("model");
            B = new b("open_search_from");
            C = new b("open_search_from_real");
            D = new b("trans_click_successful_file_type");
            E = new b("trans_file_type_count");
            F = new b("trans_cancel_file_type");
            G = new b("received_open_edit_type");
            H = new b("received_close_edit_type");
            I = new b("Scene");
            J = new b("Action");
            K = new b("fail_times");
            L = new b("Speed");
            M = new b("PageName");
            N = new b("tag");
            O = new b("error_code");
            P = new b("FileSize");
            Q = new b("FileSuffix");
            R = new b("PackageName");
            S = new b("platform");
            T = new b("from");
            U = new b("score");
            V = new b("state");
            W = new b("count");
            X = new b("no_data_up_use");
            Y = new b("no_data_up_show_select_list");
            Z = new b("no_data_up_close_way");
            aa = new b("no_data_up_get_apk_num");
            ab = new b("no_data_up_get_is_total");
            ac = new b("no_data_up_get_packages");
            ad = new b("region");
            ae = new b("downStatus");
            af = new b("NeverRemind");
            ag = new b("ConnectMode");
            ah = new b("NetMode");
            ai = new b("ConnectWay");
            aj = new b("TotalNum");
            ak = new b("scan_duration");
            al = new b("connect_duration");
            am = new b("Which");
            an = new b("current_index");
            ao = new b("NameState");
            ap = new b("Action");
            aq = new b("LinkType");
            ar = new b("EnterWay");
            as = new b("UsedPortrait");
            at = new b("funnel");
            au = new b("Duration");
            av = new b("ScanAnyone");
            aw = new b("FileAmt");
            ax = new b("scan_click_source");
            ay = new b("MiDrop_event");
            az = new b("send_status");
            aA = new b("receive_status");
            aB = new b("share_status");
            aC = new b("Why");
            aD = new b("source");
            aE = new b("option_num");
            aF = new b("page_type");
            b[] arrb = new b[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, aa, ab, ac, ad, ae, af, ag, ah, ai, aj, ak, al, am, an, ao, ap, aq, ar, as, at, au, av, aw, ax, ay, az, aA, aB, aC, aD, aE, aF};
            aH = arrb;
        }

        private b(String string3) {
            this.aG = string3;
        }

        public static b valueOf(String string2) {
            return (b)Enum.valueOf(b.class, (String)string2);
        }

        public static b[] values() {
            return (b[])aH.clone();
        }
    }

}

