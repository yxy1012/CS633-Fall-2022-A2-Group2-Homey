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
        <el-button style="background-color: #e628a6;
        position: relative; right: 6px; height: 74%; width: 25%;">
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
          <el-card :body-style="{ padding: '0px'}">
            <el-image :src="homeyOffers[index].image" style="width: 100%;height: 200px"></el-image>
          </el-card>
        </el-col>
      </el-row>
    </div>
  </div>
  <div class="unique">
    <el-row>
      <el-col :span="6"><div class="grid-content"></div></el-col>
      <el-col :span="6">
        <el-image :src="uniqueProduct.image"></el-image>
      </el-col>
      <el-col :span="8">
        <h1>Unique Features of Latest & Trending Products</h1>
        <ul>
          <li v-for="(o, index) in uniqueProduct.details" :key="o">
            {{ uniqueProduct.details[index] }}
          </li>
        </ul>
        <el-row>
          <el-col :span="6">
            <el-button style="background-color: #e628a6; color: #FFFFFF">
              Add To Cart
            </el-button>
          </el-col>
          <el-col :span="8">
            <el-row>{{ uniqueProduct.name }}</el-row>
            <el-row>{{ uniqueProduct.price }}</el-row>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
  </div>
  <div class="trendingProducts">
    <h1>Trending Products</h1>
    <el-row>
      <el-col :span="3"><div class="grid-content"></div></el-col>
      <el-col :span="4" v-for="(o, index) in 4" :key="o" class="advCard">
        <el-card :body-style="{ padding: '5px' }">
          <el-image :src="featured.image"></el-image>
          <div class="featuredDetail">
            <h4>{{ featured.name }}</h4>
            <div>
              <span>{{ latest.price }}</span>
              <span style="text-decoration: line-through; color: darkgrey">{{ latest.originalPrice }}</span>
            </div>
          </div>
        </el-card>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="3"><div class="grid-content"></div></el-col>
      <el-col :span="6">
        <el-card class="trendCard1">
          <h3>23% off in all products</h3>
          <el-link style="color: #e628a6">Shop Now</el-link>
          <el-image :src="trendCard1"  class="trendImg1"></el-image>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card class="trendCard2">
          <h3>23% off in all products</h3>
          <el-link style="color: #e628a6">View Collection</el-link>
          <el-image :src="trendCard2" class="trendImg2"></el-image>
        </el-card>
      </el-col>
      <el-col :span="5" class="trendSide">
        <el-row v-for="index in 3" :key="index" style="margin-bottom: 6%">
          <el-col :span="8">
            <el-image :src="trendImage" class="trendImage"></el-image>
          </el-col>
          <el-col :span="12">
            <el-row style="float: left; font-weight: bolder">
              Executive Seat Chair
            </el-row>
            <el-row style="float: left; text-decoration: line-through">
              $32.00
            </el-row>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
  </div>
  <div class="brands">
    <el-row>
      <el-col :span="6"><div class="grid-content"></div></el-col>
      <el-col :span="12">
        <el-image :src="brandsImage"></el-image>
      </el-col>
    </el-row>
  </div>
  <div class="pageFooter">
    <el-row>
      <el-col :span="5"><div class="grid-content"></div></el-col>
      <el-col :span="6">
        <el-row>
          <h1 style="float: left">Homey</h1>
        </el-row>
        <el-row>
          <el-input placeholder="Enter Email Address" style="width: 60%; float: left;"></el-input>
          <el-button style="float: left; width: 35%; position: relative; right: 12px;
          background-color: #e628a6; color: #FFFFFF">
            Sign up
          </el-button>
        </el-row>
        <el-row>
          <el-link style="float: left; margin-top: 5%">
            Contact Info
          </el-link>
        </el-row>
        <el-row>
          <el-link style="float: left; margin-top: 5%">
            1010 Commonwealth Avenue, Boston, MA 02215
          </el-link>
        </el-row>
      </el-col>
      <el-col :span="4" style="margin-left: 5%">
        <el-row class="categories">
          <h3>Categories</h3>
        </el-row>
        <el-row class="categories">
          <el-link>Chairs & Sofas</el-link>
        </el-row>
        <el-row class="categories">
          <el-link>Tables</el-link>
        </el-row>
        <el-row class="categories">
          <el-link>Bed</el-link>
        </el-row>
        <el-row class="categories">
          <el-link>Bookcases</el-link>
        </el-row>
        <el-row class="categories">
          <el-link>Dressers & Wardrobes</el-link>
        </el-row>
      </el-col>
      <el-col :span="4">
        <el-row class="customerCare">
          <h3>Customer Care</h3>
        </el-row>
        <el-row class="customerCare">
          <el-link>My Account</el-link>
        </el-row>
        <el-row class="customerCare">
          <el-link>Order History</el-link>
        </el-row>
        <el-row class="customerCare">
          <el-link>Order Tracking</el-link>
        </el-row>
        <el-row class="customerCare">
          <el-link>FAQ</el-link>
        </el-row>
        <el-row class="customerCare">
          <el-link>Contact Us</el-link>
        </el-row>
      </el-col>
    </el-row>
  </div>
  <div class="copyRight">
    <el-row>
      <el-col :span="6"><div style="min-height: 12px"></div></el-col>
      <el-col :span="4" style="padding-top: 1%">©Homey - All Rights Reserved</el-col>
      <el-col :span="6"><div style="min-height: 12px"></div></el-col>
      <el-col :span="4">
        <el-image :src="shareIcon" style="height: 50%; width: 50%;"></el-image>
      </el-col>
    </el-row>
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
      ],
      uniqueProduct: {
        image: require('../assets/uniqueProduct.png'),
        details: [
          'All frames constructed with hardwood solids and laminates',
          'Reinforced with wood dowels, glue, screw-nails corner blocks and machine nails',
          'Arms, backs and seats are structurally reinforced'
        ],
        name: 'B&B Italian Sofa',
        price: '$32'
      },
      trendCard1: require('../assets/trendCard1.png'),
      trendCard2: require('../assets/trendCard2.png'),
      trendImage: require('../assets/trendImage.png'),
      brandsImage: require('../assets/brandsImage.png'),
      shareIcon: require('../assets/shareIcon.png')
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
.unique{
  margin-top: 5%;
  margin-bottom: 5%;
  padding-top: 5%;
  min-height: 400px;
  background-color: #f1f0fe;
  text-align: left
}
.pageFooter{
  padding-top: 3%;
  padding-bottom: 6%;
  margin-top: 5%;
  background-color: #f1f0fe;
}
.trendCard1{
  background-color: #fef6fb;
  height: 200px;
  margin-left: 8%;
  margin-top: 10%;
  text-align: left;
}
.trendCard2{
  background-color: #efeffa;
  height: 200px;
  margin-left: 5%;
  margin-top: 10%;
  text-align: left;
}
.trendImg1{
  width: 45%;
  height: 45%;
  float: right;
}
.trendImg2{
  width: 80%;
  height: 80%;
  float: right;
}
.trendImage{
  width: 85%;
  height:85%;
  float: left;
}
.trendSide{
  margin-top: 2.5%;
  margin-left: 1.3%;
}
.brands{
  margin-top: 5%;
}
.categories{
  margin-bottom: 2%;
  text-align: left;
}
.customerCare{
  margin-bottom: 2%;
  text-align: left;
}
.copyRight{
  padding: 1%;
  background-color: #e6e4f6;
  color: darkgrey;
  font-weight: bold;
}
</style>