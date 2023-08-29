package com.ef.dylan.carteleraplus.ui.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0011H\u0016J\u0014\u0010\u0019\u001a\u00020\b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lcom/ef/dylan/carteleraplus/ui/adapter/RVTVSerieListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ef/dylan/carteleraplus/ui/adapter/TVSerieViewHolder;", "series", "", "Lcom/ef/dylan/carteleraplus/model/TVSerie;", "onTVSerieClick", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getOnTVSerieClick", "()Lkotlin/jvm/functions/Function1;", "getSeries", "()Ljava/util/List;", "setSeries", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "newSeries", "app_debug"})
public final class RVTVSerieListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.ef.dylan.carteleraplus.ui.adapter.TVSerieViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.ef.dylan.carteleraplus.model.TVSerie> series;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.ef.dylan.carteleraplus.model.TVSerie, kotlin.Unit> onTVSerieClick = null;
    
    public RVTVSerieListAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.ef.dylan.carteleraplus.model.TVSerie> series, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.ef.dylan.carteleraplus.model.TVSerie, kotlin.Unit> onTVSerieClick) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.ef.dylan.carteleraplus.model.TVSerie> getSeries() {
        return null;
    }
    
    public final void setSeries(@org.jetbrains.annotations.NotNull()
    java.util.List<com.ef.dylan.carteleraplus.model.TVSerie> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.ef.dylan.carteleraplus.model.TVSerie, kotlin.Unit> getOnTVSerieClick() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    java.util.List<com.ef.dylan.carteleraplus.model.TVSerie> newSeries) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.ef.dylan.carteleraplus.ui.adapter.TVSerieViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.ef.dylan.carteleraplus.ui.adapter.TVSerieViewHolder holder, int position) {
    }
}