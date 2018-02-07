package com.example.a21650521.apptareaglide.dataJson;

/**
 * Created by 21650521 on 07/02/2018.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PokemonForm {
    @SerializedName("is_battle_only")
    @Expose
    private Boolean isBattleOnly;
    @SerializedName("sprites")
    @Expose
    private PokemonFoto pokemonFoto;
    @SerializedName("version_group")
    @Expose
    private VersionGroup versionGroup;
    @SerializedName("form_order")
    @Expose
    private Integer formOrder;
    @SerializedName("is_mega")
    @Expose
    private Boolean isMega;
    @SerializedName("form_names")
    @Expose
    private List<Object> formNames = null;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("is_default")
    @Expose
    private Boolean isDefault;
    @SerializedName("names")
    @Expose
    private List<Object> names = null;
    @SerializedName("form_name")
    @Expose
    private String formName;
    @SerializedName("pokemon")
    @Expose
    private PokemonResult pokemon;
    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("name")
    @Expose
    private String name;

    public Boolean getIsBattleOnly() {
        return isBattleOnly;
    }

    public void setIsBattleOnly(Boolean isBattleOnly) {
        this.isBattleOnly = isBattleOnly;
    }

    public PokemonFoto getPokemonFoto() {
        return pokemonFoto;
    }

    public void setPokemonFoto(PokemonFoto pokemonFoto) {
        this.pokemonFoto = pokemonFoto;
    }

    public Integer getFormOrder() {
        return formOrder;
    }

    public void setFormOrder(Integer formOrder) {
        this.formOrder = formOrder;
    }

    public Boolean getIsMega() {
        return isMega;
    }

    public void setIsMega(Boolean isMega) {
        this.isMega = isMega;
    }

    public List<Object> getFormNames() {
        return formNames;
    }

    public void setFormNames(List<Object> formNames) {
        this.formNames = formNames;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

    public List<Object> getNames() {
        return names;
    }

    public void setNames(List<Object> names) {
        this.names = names;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public PokemonResult PokemonResult() {
        return pokemon;
    }

    public void setPokemon(PokemonResult pokemon) {
        this.pokemon = pokemon;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
