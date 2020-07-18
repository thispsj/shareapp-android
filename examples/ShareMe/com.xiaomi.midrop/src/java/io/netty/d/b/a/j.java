/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.PrintStream
 *  java.lang.Byte
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.HashSet
 *  java.util.Set
 */
package io.netty.d.b.a;

import io.netty.d.b.a.b;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

final class j {
    static b a(String string2, Object object) {
        return j.a(string2, new Object[]{object});
    }

    static b a(String string2, Object object, Object object2) {
        return j.a(string2, new Object[]{object, object2});
    }

    static b a(String string2, Object[] arrobject) {
        if (arrobject != null && arrobject.length != 0) {
            int n2 = arrobject.length - 1;
            Object object = arrobject[n2];
            Throwable throwable = object instanceof Throwable ? (Throwable)((Object)object) : null;
            if (string2 == null) {
                return new b(null, throwable);
            }
            int n3 = string2.indexOf("{}");
            if (n3 == -1) {
                return new b(string2, throwable);
            }
            StringBuilder stringBuilder = new StringBuilder(50 + string2.length());
            int n4 = 0;
            int n5 = 0;
            do {
                boolean bl = n3 == 0 || string2.charAt(n3 - 1) != '\\';
                if (bl) {
                    stringBuilder.append((CharSequence)string2, n4, n3);
                } else {
                    stringBuilder.append((CharSequence)string2, n4, n3 - 1);
                    bl = n3 >= 2 && string2.charAt(n3 - 2) == '\\';
                }
                n4 = n3 + 2;
                if (bl) {
                    j.a(stringBuilder, arrobject[n5], null);
                    if (++n5 <= n2) continue;
                    break;
                }
                stringBuilder.append("{}");
            } while ((n3 = string2.indexOf("{}", n4)) != -1);
            stringBuilder.append((CharSequence)string2, n4, string2.length());
            String string3 = stringBuilder.toString();
            Throwable throwable2 = null;
            if (n5 <= n2) {
                throwable2 = throwable;
            }
            return new b(string3, throwable2);
        }
        return new b(string2, null);
    }

    private static void a(StringBuilder stringBuilder, Object object) {
        try {
            stringBuilder.append(object.toString());
            return;
        }
        catch (Throwable throwable) {
            PrintStream printStream = System.err;
            StringBuilder stringBuilder2 = new StringBuilder("SLF4J: Failed toString() invocation on an object of type [");
            stringBuilder2.append(object.getClass().getName());
            stringBuilder2.append(']');
            printStream.println(stringBuilder2.toString());
            throwable.printStackTrace();
            stringBuilder.append("[FAILED toString()]");
            return;
        }
    }

    private static void a(StringBuilder stringBuilder, Object object, Set<Object[]> hashSet) {
        int n2;
        if (object == null) {
            stringBuilder.append("null");
            return;
        }
        Class class_ = object.getClass();
        if (!class_.isArray()) {
            if (Number.class.isAssignableFrom(class_)) {
                if (class_ == Long.class) {
                    stringBuilder.append(((Long)object).longValue());
                    return;
                }
                if (class_ != Integer.class && class_ != Short.class && class_ != Byte.class) {
                    if (class_ == Double.class) {
                        stringBuilder.append(((Double)object).doubleValue());
                        return;
                    }
                    if (class_ == Float.class) {
                        stringBuilder.append(((Float)object).floatValue());
                        return;
                    }
                    j.a(stringBuilder, object);
                    return;
                }
                stringBuilder.append(((Number)object).intValue());
                return;
            }
            j.a(stringBuilder, object);
            return;
        }
        stringBuilder.append('[');
        if (class_ == boolean[].class) {
            boolean[] arrbl = (boolean[])object;
            if (arrbl.length != 0) {
                stringBuilder.append(arrbl[0]);
                for (n2 = 1; n2 < arrbl.length; ++n2) {
                    stringBuilder.append(", ");
                    stringBuilder.append(arrbl[n2]);
                }
            }
        } else if (class_ == byte[].class) {
            byte[] arrby = (byte[])object;
            if (arrby.length != 0) {
                stringBuilder.append((int)arrby[0]);
                while (n2 < arrby.length) {
                    stringBuilder.append(", ");
                    stringBuilder.append((int)arrby[n2]);
                    ++n2;
                }
            }
        } else if (class_ == char[].class) {
            char[] arrc = (char[])object;
            if (arrc.length != 0) {
                stringBuilder.append(arrc[0]);
                while (n2 < arrc.length) {
                    stringBuilder.append(", ");
                    stringBuilder.append(arrc[n2]);
                    ++n2;
                }
            }
        } else if (class_ == short[].class) {
            short[] arrs = (short[])object;
            if (arrs.length != 0) {
                stringBuilder.append((int)arrs[0]);
                while (n2 < arrs.length) {
                    stringBuilder.append(", ");
                    stringBuilder.append((int)arrs[n2]);
                    ++n2;
                }
            }
        } else if (class_ == int[].class) {
            int[] arrn = (int[])object;
            if (arrn.length != 0) {
                stringBuilder.append(arrn[0]);
                while (n2 < arrn.length) {
                    stringBuilder.append(", ");
                    stringBuilder.append(arrn[n2]);
                    ++n2;
                }
            }
        } else if (class_ == long[].class) {
            long[] arrl = (long[])object;
            if (arrl.length != 0) {
                stringBuilder.append(arrl[0]);
                while (n2 < arrl.length) {
                    stringBuilder.append(", ");
                    stringBuilder.append(arrl[n2]);
                    ++n2;
                }
            }
        } else if (class_ == float[].class) {
            float[] arrf = (float[])object;
            if (arrf.length != 0) {
                stringBuilder.append(arrf[0]);
                while (n2 < arrf.length) {
                    stringBuilder.append(", ");
                    stringBuilder.append(arrf[n2]);
                    ++n2;
                }
            }
        } else if (class_ == double[].class) {
            double[] arrd = (double[])object;
            if (arrd.length != 0) {
                stringBuilder.append(arrd[0]);
                while (n2 < arrd.length) {
                    stringBuilder.append(", ");
                    stringBuilder.append(arrd[n2]);
                    ++n2;
                }
            }
        } else {
            Object[] arrobject = (Object[])object;
            if (arrobject.length != 0) {
                if (hashSet == null) {
                    hashSet = new HashSet(arrobject.length);
                }
                if (hashSet.add((Object)arrobject)) {
                    j.a(stringBuilder, arrobject[0], (Set<Object[]>)hashSet);
                    while (n2 < arrobject.length) {
                        stringBuilder.append(", ");
                        j.a(stringBuilder, arrobject[n2], (Set<Object[]>)hashSet);
                        ++n2;
                    }
                    hashSet.remove((Object)arrobject);
                } else {
                    stringBuilder.append("...");
                }
            }
        }
        stringBuilder.append(']');
    }
}

