import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { QuickanswerComponent } from './components/quickanswer/quickanswer.component';
import { ChillaxComponent } from './components/chillax/chillax.component';
import { ConvertamountComponent } from './components/convertamount/convertamount.component';
import { ResbycalComponent } from './components/resbycal/resbycal.component';
import { NutbydishComponent } from './components/nutbydish/nutbydish.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    QuickanswerComponent,
    ChillaxComponent,
    ConvertamountComponent,
    ResbycalComponent,
    NutbydishComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
