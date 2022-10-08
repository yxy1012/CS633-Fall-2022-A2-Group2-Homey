<template>
<div>
  <div class="pageHeader">
    <el-row>
      <el-col :span="5"><div class="grid-content"></div></el-col>
      <el-col :span="3"><div class="grid-content"><i class="el-icon-message r-spacing"></i>{{ user.username }}</div></el-col>
      <el-col :span="3"><div class="grid-content"><i class="el-icon-phone-outline r-spacing"></i>{{ phone }}</div></el-col>
      <el-col :span="7"><div class="grid-content"></div></el-col>
      <el-col :span="1"><div class="grid-content">{{ login }}<i class="el-icon-user l-spacing"></i></div></el-col>
      <el-col :span="2"><div class="grid-content">{{ wishlist }}<i class="el-icon-star-off l-spacing"></i></div></el-col>
      <el-col :span="1"><div class="grid-content chartIcon"><i class="el-icon-shopping-cart-2"></i></div></el-col>
      <el-col :span="2"><div class="grid-content"></div></el-col>
    </el-row>
  </div>
  <div class="topMenu">
    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
      <el-menu-item class="logoArea">
        <el-image :src="logoUrl" style="width: 180px; height: 50px"></el-image>
      </el-menu-item>
      <el-submenu index="1">
        <template slot="title">Home</template>
        <el-menu-item index="1-1">1</el-menu-item>
        <el-menu-item index="1-2">2</el-menu-item>
        <el-menu-item index="1-3">3</el-menu-item>
      </el-submenu>
      <el-menu-item index="2">Pages</el-menu-item>
      <el-menu-item index="3">Products</el-menu-item>
      <el-menu-item index="4">Blog</el-menu-item>
      <el-menu-item index="5">Shop</el-menu-item>
      <el-menu-item index="6">Contact</el-menu-item>
      <el-menu-item class="searchArea">
        <el-input v-model="searchContent" placeholder="" class="searchInput"></el-input>
        <el-button class="searchButton">
          <i class="el-icon-search searchIcon"></i>
        </el-button>
      </el-menu-item>
    </el-menu>
  </div>
  <div class="advArea">
    <el-carousel height="600px">
      <el-carousel-item v-for="item in 4" :key="item">
        <el-image :src="advImage"></el-image>
      </el-carousel-item>
    </el-carousel>
  </div>
  <div class="featuredProducts">
    <div>
      <h1>Featured Products</h1>
    </div>
    <div class="featuredList">
      <el-carousel height="400px">
        <el-carousel-item v-for="item in 4" :key="item">
          <el-row>
            <el-col :span="3"><div class="grid-content"></div></el-col>
            <el-col :span="4" v-for="(o, index) in 4" :key="o" class="advCard">
              <el-card :body-style="{ padding: '0px' }">
                <el-image :src="featured.image"></el-image>
                <div class="featuredDetail">
                  <h4>{{ featured.name }}</h4>
                  <div>
                    {{ featured.id }}
                  </div>
                  <div>
                    {{ featured.price }}
                  </div>
                </div>
              </el-card>
            </el-col>
          </el-row>
        </el-carousel-item>
      </el-carousel>
    </div>
  </div>
  <div class="latestProducts">
    <div>
      <h1>Latest Products</h1>
    </div>
    <div>
      <el-row>
        <el-col :span="8"><div class="grid-content"></div></el-col>
        <el-col :span="2"><el-link type="danger">New Arrival</el-link></el-col>
        <el-col :span="2"><el-link type="danger">Best Seller</el-link></el-col>
        <el-col :span="2"><el-link type="danger">Featured</el-link></el-col>
        <el-col :span="2"><el-link type="danger">Special Offer</el-link></el-col>
      </el-row>
    </div>
  </div>
  <div class="latestList">
    <el-row>
      <el-col :span="6" v-for="(o, index) in 6" :key="o" class="latestItem">
        <el-image :src="latest.image"></el-image>
        <span style="float: left">{{ latest.name }}</span>
        <span style="float: right; color: red; text-decoration: line-through">{{ latest.originalPrice }}</span>
        <span style="float: right">{{ latest.price }}</span>
      </el-col>
    </el-row>
  </div>
  <div class="homeyOffer">
    <div>
      <h1>What Homey Offer!</h1>
    </div>
    <div>
      <el-row>
        <el-col :span="5"><div class="grid-content"></div></el-col>
        <el-col :span="3" v-for="(o, index) in homeyOffers" :key="o" class="advCard">
          <el-card :body-style="{ padding: '0px' }">
            <el-image :src="homeyOffers[index].image"></el-image>
          </el-card>
        </el-col>
      </el-row>
    </div>
  </div>
</div>
</template>

<script>
export default {
  name: "Home",
  data(){
    return {
      user:{
        username: 'xinyuy@bu.edu'
      },
      phone: '(617)717-2771',
      login: 'Login',
      wishlist: 'Wishlist',
      activeIndex: '1-1',
      logoUrl: require('../assets/logo.png'),
      searchContent:'',
      advImage: require('../assets/advImage1.png'),
      featured:{
        image: require('../assets/featured1.png'),
        name: 'Cantilever chair',
        price: '$42.00',
        id: 'Code - Y523201'
      },
      latest:{
        image: require('../assets/latestImage1.png'),
        name: 'Comfort Handy Craft',
        originalPrice: '$65.00',
        price: '$42.00'
      },
      homeyOffers:[
        {
          image: require('../assets/homeyOffer1.png')
        },
        {
          image: require('../assets/homeyOffer2.png')
        },
        {
          image: require('../assets/homeyOffer3.png')
        },
        {
          image: require('../assets/homeyOffer4.png')
        }
      ]
    }
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>

<style scoped>
.pageHeader{
  background-color: #6729e8;
  width: 100%;
  height: 30px;
}
.grid-content{
  color: #FFFFFF;
  font-size: medium;
  font-weight: bold;
  min-height: 36px;
}
.chartIcon{
  float: left;
}
.r-spacing{
  margin-right: 3%;
}
.l-spacing{
  margin-left: 2%;
}
.logoArea{
  padding-left: 20%;
}
.searchArea{
  padding-left: 5%;
  width: 25%;
}
.searchButton{
  position: relative;
  right: 6px;
  height: 74%;
  width: 25%;
  background-color: #e628a6;
}
.searchInput{
  width: 80%;
}
.searchIcon{
  color: #FFFFFF;
}
.featuredProducts{
  margin-top: 5%;
}
.featuredList{
  margin-bottom: 5%;
}
.advCard{
  margin-left: 2%;
}
.featuredDetail{
  padding-bottom: 5%;
}
.latestList{
  margin-left: 17%;
  margin-bottom: 5%;
}
.latestItem{
  margin-right: 2%;
}
</style>